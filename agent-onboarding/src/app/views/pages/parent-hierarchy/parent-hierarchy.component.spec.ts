import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentHierarchyComponent } from './parent-hierarchy.component';

describe('ParentHierarchyComponent', () => {
  let component: ParentHierarchyComponent;
  let fixture: ComponentFixture<ParentHierarchyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParentHierarchyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParentHierarchyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
