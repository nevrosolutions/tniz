import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditIndividualHierarchyComponent } from './edit-individual-hierarchy.component';

describe('EditIndividualHierarchyComponent', () => {
  let component: EditIndividualHierarchyComponent;
  let fixture: ComponentFixture<EditIndividualHierarchyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditIndividualHierarchyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditIndividualHierarchyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
