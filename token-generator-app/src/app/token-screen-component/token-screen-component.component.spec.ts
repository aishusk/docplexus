import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TokenScreenComponentComponent } from './token-screen-component.component';

describe('TokenScreenComponentComponent', () => {
  let component: TokenScreenComponentComponent;
  let fixture: ComponentFixture<TokenScreenComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TokenScreenComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TokenScreenComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
