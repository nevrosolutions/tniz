// Angular
import { Component, OnInit } from '@angular/core';
// Lodash
import { finalize, tap } from 'rxjs/operators';
// Services
// Widgets model
import { BusinessUnitModel } from '../../../core/e-commerce/_models/business-unit.model';
import { DesignationModel } from '../../../core/e-commerce/_models/designation.model';
import { AgentService } from '../../../core/e-commerce/_services';

@Component({
	selector: 'kt-dashboard',
	templateUrl: './dashboard.component.html',
	styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

	businessUnits: BusinessUnitModel[];
	designations: DesignationModel[];
	hierarchyNode: IHierarchyNode[] = []

	constructor(
		private agentService: AgentService) {
		this.getAllBusinessUnits();
		this.getAllDesignations();
	}

	ngOnInit(): void {
	}

	getAllBusinessUnits(): void {
		this.agentService.getAllBusinessUnits()
			.pipe(
				tap(businessUnit => {
					if (businessUnit) {
						this.businessUnits = businessUnit;
					} else {
						console.log('No business units have been found');
					}
				}),
				finalize(() => {
				})
			)
			.subscribe();
	}

	getAllDesignations(): void {
		this.agentService.getAllDesignations()
			.pipe(
				tap(designation => {
					if (designation) {
						this.designations = designation;
					} else {
						console.log('No designations have been found');
					}
				}),
				finalize(() => {
				})
			)
			.subscribe();
	}

}

export interface IHierarchyNode {
	hierarchyNodeId: number;
	businessUnitId: {
		businessUnitId: number
	};
	hierarchyType: string;
	designationId: {
		designationId: number
	};
	agentGroupCategory: {
		agentId: number
	};
}
