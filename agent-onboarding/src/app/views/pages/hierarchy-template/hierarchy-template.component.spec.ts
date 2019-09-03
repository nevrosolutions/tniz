import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HierarchyTemplateComponent } from './hierarchy-template.component';

describe('HierarchyTemplateComponent', () => {
  let component: HierarchyTemplateComponent;
  let fixture: ComponentFixture<HierarchyTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HierarchyTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HierarchyTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
