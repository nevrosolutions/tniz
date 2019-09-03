import { CdkDragDrop, copyArrayItem } from '@angular/cdk/drag-drop';
import { DatePipe } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { MAT_DATE_FORMATS, MAT_DATE_LOCALE, MatDatepicker, MatSnackBar } from '@angular/material';
import { MatMomentDateModule } from '@angular/material-moment-adapter';

import { BusinessUnit } from '../../../core/hierarchy-template/_models/business-unit.model';
import { BusinessUnitService } from '../../../core/hierarchy-template/_services/business.unit.service';
import { HierarchyNodeTemplateService } from '../../../core/hierarchy-template/_services/hierarchy.node.template.service';
import { AgentCategoryService } from '../../../core/manage-agent-category/_services/agent.category.service';
import { DesignationService } from '../../../core/manage-designation/_services/designation.service';
import { ParentHierarchyNodeModel, ParentHierarchySaveNodeModel } from '../../../core/parent-hierarchy/_models/parent-hierarchy-node.model';
import { ParentHierarchyService } from '../../../core/parent-hierarchy/_services/parent-hierarchy.service';

export const DateFormat = {
	parse: {
		dateInput: 'input',
	},
	display: {
		dateInput: 'YYYY-MM-DD',
		monthYearLabel: 'YYYY MMMM',
		dateA11yLabel: 'YYYY-MM-DD',
		monthYearA11yLabel: 'YYYY MMMM',
	}
};

@Component({
	selector: 'kt-parent-hierarchy',
	templateUrl: './parent-hierarchy.component.html',
	styleUrls: ['./parent-hierarchy.component.scss'],
	providers: [
		{provide: MatDatepicker, useClass: MatMomentDateModule, deps: [MAT_DATE_LOCALE]},
		{provide: MAT_DATE_FORMATS, useValue: DateFormat}
	]
})
export class ParentHierarchyComponent implements OnInit {

	parentHierarchyNodeList: ParentHierarchyNodeModel[];
	workspaceList: ParentHierarchyNodeModel[] = [];
	buildingHierarchyParentNodeList: ParentHierarchySaveNodeModel[] = [];
	businessUnits: BusinessUnit[];
	selectedBusinessUnit: number;
	currentDropType: DropTypes;
	isChildSelected = false;
	currentChild = {
		label: '',
		code: ''
	};
	effectiveFrom: string[] = [];
	currentParentDrop: CdkDragDrop<any[]>;

	@ViewChild('myDatepicker', {static: false}) datePicker: MatDatepicker<Date>;

	constructor(private businessUnitService: BusinessUnitService,
				private designationService: DesignationService,
				private agentCategoryService: AgentCategoryService,
				private hierarchyTemplateService: HierarchyNodeTemplateService,
				private parentHierarchyService: ParentHierarchyService,
				private snackBar: MatSnackBar,
				private cdr: ChangeDetectorRef,
				public datePipe: DatePipe) {
	}

	ngOnInit() {
		this.getBusinessUnits();
		this.detectChanges();
	}

	getBusinessUnits() {
		this.businessUnitService.getBusinessUnits().subscribe((data: BusinessUnit []) => {
			this.businessUnits = data;
		});
	}

	getHierarchyNodeTemplate() {
		this.parentHierarchyNodeList = null;
		this.snackBar.dismiss();

		this.parentHierarchyService.getHierarchyTemplateByBusinessId(this.selectedBusinessUnit)
			.subscribe((data: ParentHierarchyNodeModel[]) => {
				if (data.length) {
					this.parentHierarchyNodeList = data;
				} else {
					this.snackBar.open('No hierarchy templates have been found', null, {
						duration: 2000
					});
				}
				this.detectChanges();
			});
	}

	setDropType(dropType: string) {
		this.currentDropType = dropType as DropTypes;
	}

	drop(event: CdkDragDrop<any[]>) {
		if (event.previousContainer === event.container) {
			// moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
		} else {
			copyArrayItem(event.previousContainer.data,
				event.container.data,
				event.previousIndex,
				event.currentIndex);

			switch(this.currentDropType) {
				case DropTypes.CHILD:
					this.currentChild = {
						code: event.container.data[0].agentGroupCategory.code,
						label: event.container.data[0].agentGroupCategory.label
					};
					this.isChildSelected = true;
					break;
				case DropTypes.PARENT:
					this.openCalendar();
					this.currentParentDrop = event;
					break;
			}

			this.workspaceList = event.container.data;
		}
	}

	setDropEventData(event: CdkDragDrop<any[]>) {
		this.buildingHierarchyParentNodeList = [];

		event.container.data.forEach((data: any, idx: number) => {
			const parentHierarchy = new ParentHierarchySaveNodeModel();

			if (idx !== 0) {
				parentHierarchy.hierarchyNodeDetailId = -1;
				parentHierarchy.hierarchyNodeId = {
					hierarchyNodeId: event.container.data[0].hierarchyNodeId
				};
				parentHierarchy.parentNodeId = {
					hierarchyNodeId: data.hierarchyNodeId
				};
				parentHierarchy.status = 'ACT';
				parentHierarchy.effectiveFrom = this.effectiveFrom[idx];
				parentHierarchy.effectiveTo = '';

				this.buildingHierarchyParentNodeList.push(parentHierarchy);
			}
		});
	}

	deleteParent(index: number) {
		this.workspaceList.splice(index, 1);
		this.buildingHierarchyParentNodeList.splice(index - 1, 1);
		this.effectiveFrom.splice(index, 1);
	}

	detectChanges() {
		this.cdr.markForCheck();
	}

	dateChanged(event) {
		if (this.effectiveFrom.length === 0) {
			this.effectiveFrom.push('');
		}
		const selectedDate = this.datePipe.transform(event.targetElement.value, 'yyyy-MM-dd');

		this.effectiveFrom.push(selectedDate);

		this.setDropEventData(this.currentParentDrop);
		this.closeCalendar();
		this.detectChanges();
	}

	openCalendar() {
		const elem = document.getElementById('datePicker');
		elem.style.display = 'block';

		this.datePicker.open();
	}

	closeCalendar() {
		const elem = document.getElementById('datePicker');
		elem.style.display = 'none';

		this.datePicker.close();
	}

	saveHierarchyParentNode() {
		this.parentHierarchyService.saveHierarchyParentNode(this.buildingHierarchyParentNodeList)
			.subscribe((data: ParentHierarchyNodeModel[]) => {
				if (data.length) {
					this.snackBar.open('Successfully saved parent hierarchy node', null, {
						duration: 2000
					});
				} else {
					this.snackBar.open('Unable to save parent hierarchy node', null, {
						duration: 2000
					});
				}
				this.resetItems();
				this.detectChanges();
			});
	}

	resetItems() {
		this.workspaceList = [];
		this.isChildSelected = false;
		this.currentChild = {
			code: '',
			label: ''
		};
	}

}

enum DropTypes {
	PARENT = 'p',
	CHILD = 'c'
}
