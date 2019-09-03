import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualHierarchyComponent } from './individual-hierarchy.component';

describe('IndividualHierarchyComponent', () => {
  let component: IndividualHierarchyComponent;
  let fixture: ComponentFixture<IndividualHierarchyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndividualHierarchyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualHierarchyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
