import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectTokenComponentComponent } from './collect-token-component.component';

describe('CollectTokenComponentComponent', () => {
  let component: CollectTokenComponentComponent;
  let fixture: ComponentFixture<CollectTokenComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollectTokenComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectTokenComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
