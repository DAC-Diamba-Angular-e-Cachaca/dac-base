import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalReprovarClienteComponent } from './modal-reprovar-cliente.component';

describe('ModalReprovarClienteComponent', () => {
  let component: ModalReprovarClienteComponent;
  let fixture: ComponentFixture<ModalReprovarClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalReprovarClienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalReprovarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
