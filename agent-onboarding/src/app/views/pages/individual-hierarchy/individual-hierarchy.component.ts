import { DatePipe } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS, MatDialog, MatSnackBar } from '@angular/material';
import { APP_DATE_FORMATS, AppDateAdapter } from '../../../core/manage-individual-heirarchy/_addapters/customDateAdapter';
import { IndividualHeirarchyService } from './../../../core/manage-individual-heirarchy/_services/individual-heirarchy.service';
import { EditIndividualHierarchyComponent } from './edit-individual-hierarchy/edit-individual-hierarchy.component';

@Component({
	selector: 'kt-individual-hierarchy',
	templateUrl: './individual-hierarchy.component.html',
	styleUrls: ['./individual-hierarchy.component.scss'],
	providers: [
		{provide: DateAdapter, useClass: AppDateAdapter},
		{provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS},
		DatePipe
	]
})
export class IndividualHierarchyComponent implements OnInit {

	public displayedColumns: string[] = ['Effective From', 'Effective To', 'Designation', 'Parent', 'Bussiness Unit', 'Action'];
	public dataSource: any | [];
	public effectiveToFormGroup: FormGroup;
	public searchFormGroup: FormGroup;
	public bussinessUnitArray: any;

	constructor(
		private dialog: MatDialog,
		private fb: FormBuilder,
		private ihService: IndividualHeirarchyService,
		private snackBar: MatSnackBar,
		private crf: ChangeDetectorRef) { }

	ngOnInit() {
		this.createEffectiveToFormGroup();
		this.createSearchFormGroup();
		this.getAllBussinesUnit();
	}

	createSearchFormGroup() {
		this.searchFormGroup = this.fb.group({
			agentId: ['', Validators.required],
			bussinesUnitId: ['', Validators.required]
		});
	}

	createEffectiveToFormGroup() {
		this.effectiveToFormGroup = this.fb.group({
			effectiveTo: ['', Validators.required]
		});
	}

	openDialog(individualHierarchyData): void {
		if (this.effectiveToFormGroup.value.effectiveTo == '') {
			this.snackBar.open('Please Select Effective To Date', 'Close', {
				duration: 2000,
			});
		} else {
			let effecFrom = this.effectiveToFormGroup.value.effectiveTo;
			effecFrom = new Date(effecFrom.setDate(effecFrom.getDate() + 1));

			const data = {
				systemId: individualHierarchyData.agentSystemId.agentId,
				bussinesUnit: individualHierarchyData.businessUnit.businessUnitId,
				effectiveFrom: effecFrom,
				effectiveTo: '',
				designation: individualHierarchyData.agentSystemId.designation,
				parent: individualHierarchyData.parentSystemId.agentId
			};

			const dialogRef = this.dialog.open(EditIndividualHierarchyComponent, {
				width: '600px',
				data: {ihData: individualHierarchyData, formData: data}
			});

			dialogRef.afterClosed().subscribe(result => {
				this.getAgentFromAgent();
			});
		}
	}

	getAllBussinesUnit() {
		this.ihService.getAllBussinessUnit().subscribe(response => {
				this.bussinessUnitArray = response;
			},
			error => {
				console.log(error);
			});
	}

	getAgentFromAgent() {
		const agentId = this.searchFormGroup.value.agentId;
		const bussinesUnitId = this.searchFormGroup.value.bussinesUnitId;
		this.ihService.getAgentFromAgent(agentId, bussinesUnitId)
			.subscribe(response => {
					console.log(response);
					this.dataSource = response;
					this.crf.markForCheck();
					this.effectiveToFormGroup.reset();
				},
				error => {
					console.log(error);
				});
	}

}

