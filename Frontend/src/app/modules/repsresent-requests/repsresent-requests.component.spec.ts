import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RepsresentRequestsComponent } from './repsresent-requests.component';

describe('RepsresentRequestsComponent', () => {
  let component: RepsresentRequestsComponent;
  let fixture: ComponentFixture<RepsresentRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RepsresentRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RepsresentRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
