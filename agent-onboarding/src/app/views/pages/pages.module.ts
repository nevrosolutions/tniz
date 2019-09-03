// Angular
import { DragDropModule } from '@angular/cdk/drag-drop';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
// Material
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatIconModule, MatInputModule, MatSelectModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { ngxLoadingAnimationTypes, NgxLoadingModule } from 'ngx-loading';
// Pages
import { CoreModule } from '../../core/core.module';
// Partials
import { PartialsModule } from '../partials/partials.module';
import { IndividualHeirarchyService } from './../../core/manage-individual-heirarchy/_services/individual-heirarchy.service';
import { HierarchyTemplateComponent } from './hierarchy-template/hierarchy-template.component';
import { EditIndividualHierarchyComponent } from './individual-hierarchy/edit-individual-hierarchy/edit-individual-hierarchy.component';
import { IndividualHierarchyComponent } from './individual-hierarchy/individual-hierarchy.component';
import { ParentHierarchyComponent } from './parent-hierarchy/parent-hierarchy.component';

@NgModule({
	declarations: [
		HierarchyTemplateComponent,
		IndividualHierarchyComponent,
		EditIndividualHierarchyComponent,
		ParentHierarchyComponent
	],
	exports: [],
	imports: [
		CommonModule,
		HttpClientModule,
		FormsModule,
		ReactiveFormsModule,
		CoreModule,
		PartialsModule,
		FlexLayoutModule,
		MatCardModule,
		MatSelectModule,
		MatInputModule,
		MatButtonModule,
		MatTableModule,
		MatDatepickerModule,
		MatDialogModule,
		MatNativeDateModule,
		MatRippleModule,
		MatIconModule,
		MatSnackBarModule,
		MatProgressSpinnerModule,
		DragDropModule,
		MatIconModule,
		MatFormFieldModule,
		MatInputModule,
		MatSelectModule,
		MatSnackBarModule,
		NgxLoadingModule.forRoot({
			animationType: ngxLoadingAnimationTypes.chasingDots
		})
	],
	providers: [
		EditIndividualHierarchyComponent,
		IndividualHeirarchyService
	],
	entryComponents: [EditIndividualHierarchyComponent]
})
export class PagesModule {
}
