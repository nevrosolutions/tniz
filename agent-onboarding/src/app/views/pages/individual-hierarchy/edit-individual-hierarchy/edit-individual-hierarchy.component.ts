import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DIALOG_DATA, MatDialogRef, MatSnackBar } from '@angular/material';

import { APP_DATE_FORMATS, AppDateAdapter } from '../../../../core/manage-individual-heirarchy/_addapters/customDateAdapter';
import { Agent } from './../../../../core/manage-individual-heirarchy/_models/agent.model';
import { BussinesUnit } from './../../../../core/manage-individual-heirarchy/_models/bussinesUnit.model';
import { CreateIH } from './../../../../core/manage-individual-heirarchy/_models/createIH.model';
import { Designation } from './../../../../core/manage-individual-heirarchy/_models/designation.model';
import { IndividualHeirarchyService } from './../../../../core/manage-individual-heirarchy/_services/individual-heirarchy.service';

@Component({
	selector: 'kt-edit-individual-hierarchy',
	templateUrl: './edit-individual-hierarchy.component.html',
	styleUrls: ['./edit-individual-hierarchy.component.scss'],
	providers: [
		{provide: DateAdapter, useClass: AppDateAdapter},
		{provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
	]
})
export class EditIndividualHierarchyComponent implements OnInit {

	public editIhFormGroup: FormGroup;
	public designationList: any;
	public bussinessUnitArray: any;
	public parentlist: any;

	constructor(
		public dialogRef: MatDialogRef<EditIndividualHierarchyComponent>,
		@Inject(MAT_DIALOG_DATA) public data,
		public fb: FormBuilder,
		private ihService: IndividualHeirarchyService,
		private snackBar: MatSnackBar,
		private crf: ChangeDetectorRef
	) { }

	ngOnInit() {
		this.createUpdateIhForm(this.data.formData);
		this.getAllDesignation();
		this.getAllBussinesUnit();
		this.getParentList(this.data.ihData.businessUnit.businessUnitId, this.data.ihData.designationType.designationId);
	}

	createUpdateIhForm(formData) {
		this.editIhFormGroup = this.fb.group({
			bussinesUnit: [formData.bussinesUnit ? formData.bussinesUnit : '', Validators.required],
			effectiveFrom: [formData.effectiveFrom ? formData.effectiveFrom : '', Validators.required],
			designation: [formData.designation ? formData.designation : '', Validators.required],
			parent: [formData.parent ? formData.parent : '', Validators.required],
		});
	}

	onChangeDesignation(event) {
		console.log(event);
		const butId = this.editIhFormGroup.value.bussinesUnit;
		const degId = event.value;
		this.getParentList(butId, degId);
	}

	onChangeBut(event) {
		console.log(event);
		const butId = event.value;
		const degId = this.editIhFormGroup.value.designation;
		this.getParentList(butId, degId);
	}

	updateData() {
		const effecTo = this.editIhFormGroup.value.effectiveFrom;
		this.data.ihData.effectiveTo = new Date(effecTo.setDate(effecTo.getDate() - 1));

		this.ihService.updateIhData(this.data.ihData).subscribe(response => {
				console.log('IH Record Updated');
				this.snackBar.open('Record Updated', 'Close', {
					duration: 1000,
				});

				let createIh = new CreateIH();
				let agent = new Agent();
				let bussinessUnit = new BussinesUnit();
				let parent = new Agent();
				let designation = new Designation();

				agent.agentId = this.data.ihData.agentSystemId.agentId;
				bussinessUnit.businessUnitId = this.data.ihData.businessUnit.businessUnitId;
				parent.agentId = this.editIhFormGroup.value.parent;
				designation.designationId = this.editIhFormGroup.value.designation;

				createIh.agentSystemId = agent;
				createIh.branchcode = this.data.ihData.branchcode;
				createIh.businessUnit = bussinessUnit;
				createIh.designationType = designation;
				createIh.effectiveFrom = this.editIhFormGroup.value.effectiveFrom;
				createIh.effectiveTo = '';
				createIh.parentSystemId = parent;

				this.ihService.createNewIhRecord(createIh).subscribe(response => {
						this.snackBar.open('New Designation Appointed', 'Close', {
							duration: 2000,
						});
						console.log('New IH Record Created');
						this.dialogRef.close();
					},
					error => {
						console.log('Error Creating New IH Record');
						this.snackBar.open('Error Appointing New Designation', 'Close', {
							duration: 2000,
						});
					});
			},
			error => {
				console.log('Error Updateing IH Record');
				this.snackBar.open('Error Updating Effective To Date', 'Close', {
					duration: 2000,
				});
			});
	}

	getAllDesignation() {
		this.ihService.getAllDesignation()
			.subscribe(response => {
					console.log(response);
					this.designationList = response;
				},
				error => {
					console.log(error);
				});
	}

	getAllBussinesUnit() {
		this.ihService.getAllBussinessUnit().subscribe(response => {
				this.bussinessUnitArray = response;
			},
			error => {
				console.log(error);
			});
	}

	getParentList(businessUnitId, designationId) {
		this.ihService.getParentList(businessUnitId, designationId).subscribe(response => {
				this.parentlist = response;
				console.log(this.parentlist);
				this.crf.markForCheck();
			},
			error => {
				console.log(error);
			});
	}

}
