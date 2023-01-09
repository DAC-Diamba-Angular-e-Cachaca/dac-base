import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarTopClientesComponent } from './consultar-top-clientes.component';

describe('ConsultarTopClientesComponent', () => {
  let component: ConsultarTopClientesComponent;
  let fixture: ComponentFixture<ConsultarTopClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultarTopClientesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultarTopClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
