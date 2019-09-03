import { CdkDragDrop, copyArrayItem, moveItemInArray } from '@angular/cdk/drag-drop';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material';

import { BusinessUnit } from '../../../core/hierarchy-template/_models/business-unit.model';
import { HierarchyNode } from '../../../core/hierarchy-template/_models/hierarchy-node.model';
import { BusinessUnitService } from '../../../core/hierarchy-template/_services/business.unit.service';
import { HierarchyNodeTemplateService } from '../../../core/hierarchy-template/_services/hierarchy.node.template.service';
import { AgentCategory } from '../../../core/manage-agent-category/_models/agent-category.model';
import { AgentCategoryService } from '../../../core/manage-agent-category/_services/agent.category.service';
import { Designation } from '../../../core/manage-designation/_models/designation.model';
import { DesignationService } from '../../../core/manage-designation/_services/designation.service';

@Component({
	selector: 'kt-hierarchy-template',
	templateUrl: './hierarchy-template.component.html',
	styleUrls: ['./hierarchy-template.component.scss']
})
export class HierarchyTemplateComponent implements OnInit {
	private designations = [];
	private categories = [];
	private builtHierarchyNodeList = [];
	private alreadyExistHierarchyNodeList = [];
	private workspaceList = [];
	private showMessage = false;
	private MESSAGE_SAME_ITEM_PROCESS = 'Same items cannot be processed...!';
	private MESSAGE_ALREADY_EXIST = 'Hierarchy already exist...!';
	private MESSAGE_SUCCESS_SAVE = 'Successfully save...!';
	private message: string;
	businessUnits: BusinessUnit[];
	hierarchyTypes: {name, value}[];
	selectedBusinessUnit: BusinessUnit;
	selectedHierarchyType: string;
	private successFullySaved = false;

	constructor(private businessUnitService: BusinessUnitService,
				private designationService: DesignationService,
				private agentCategoryService: AgentCategoryService,
				private hierarchyTemplateService: HierarchyNodeTemplateService,
				private cdr: ChangeDetectorRef,
				private matSnackBar: MatSnackBar,
	) {
		this.businessUnitService.getBusinessUnits().subscribe((data: BusinessUnit []) => {
			this.businessUnits = data;
		});
		this.designationService.getDesignations().subscribe((data: Designation[]) => {
			this.designations = data;
			this.designations.forEach((designation: any) => {
				designation.isDesignation = true;
			});
		});
		this.agentCategoryService.getAgentCategory().subscribe((data: AgentCategory[]) => {
			this.categories = data;
			this.categories.forEach((category: any) => {
				category.isCategory = true;
			});
		});
	}

	ngOnInit(): void {
		this.hierarchyTypes = [
			{
				name: 'PRIMARY',
				value: 'P'
			},
			{
				name: 'SECONDARY',
				value: 'S'
			}
		];
	}

	drop(event: CdkDragDrop<any[]>) {
		if (event.previousContainer === event.container) {
			moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
		} else {
			copyArrayItem(event.previousContainer.data,
				event.container.data,
				event.previousIndex,
				event.currentIndex);
			this.showMessage = false;
			if (event.container.data.length === 2) {
				const firstElement = event.container.data[0];
				const secondElement = event.container.data[1];
				if (((firstElement.isDesignation && secondElement.isDesignation) || (firstElement.isCategory && secondElement.isCategory))) {
					this.showMessage = true;
					this.message = this.MESSAGE_SAME_ITEM_PROCESS;
					this.workspaceList = [];
				} else {
					const h = new HierarchyNode();
					h.businessUnit = this.selectedBusinessUnit;
					if (secondElement.isCategory === true) {
						h.agentGroupCategory = secondElement;
					} else {
						h.designation = secondElement;
					}
					if (firstElement.isDesignation === true) {
						h.designation = firstElement;
					} else {
						h.agentGroupCategory = firstElement;
					}
					h.hierarchyType = this.selectedHierarchyType;
					if (this.validateExistence(h)) {
						this.showMessage = true;
						this.message = this.MESSAGE_ALREADY_EXIST;
					} else {
						this.builtHierarchyNodeList.push(h);
					}
					this.workspaceList = [];
				}
			}
		}
	}

	deleteItem(item: any, index: number) {
		this.workspaceList.splice(index, 1);
	}

	private validateExistence(h: HierarchyNode) {
		const is = this.builtHierarchyNodeList.some(item => item.designation.label.trim() === h.designation.label.trim() &&
			item.agentGroupCategory.label.trim() === h.agentGroupCategory.label.trim() && item.hierarchyType === h.hierarchyType)
			|| this.alreadyExistHierarchyNodeList.some(item => item.designation.label.trim() === h.designation.label.trim() &&
				item.agentGroupCategory.label.trim() === h.agentGroupCategory.label.trim() && item.hierarchyType === h.hierarchyType);
		return is;
	}

	dropCategory(event: CdkDragDrop<any[], any>) {

	}

	saveHierarchyNodeTemplate() {
		this.hierarchyTemplateService.saveHierarchyTemplate(this.builtHierarchyNodeList).subscribe((data: HierarchyNode[]) => {
			if (data !== undefined) {
				// tslint:disable-next-line:no-unused-expression
				const snackRef = this.matSnackBar.open(this.MESSAGE_SUCCESS_SAVE, 'x', {duration: 1000});
				snackRef.afterDismissed().subscribe(() => {
					this.builtHierarchyNodeList = [];
					this.loadExistingHierarchyNodeTemplate();
					this.cdr.markForCheck();
				});
			}
		});
	}

	loadExistingHierarchyNodeTemplate() {
		this.hierarchyTemplateService.getHierarchyTemplateByBusinessId(this.selectedBusinessUnit, this.selectedHierarchyType).subscribe((data: HierarchyNode[]) => {
			this.alreadyExistHierarchyNodeList = data;
		});
	}
}
