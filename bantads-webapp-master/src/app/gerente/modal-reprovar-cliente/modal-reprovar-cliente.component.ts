import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Cliente } from 'src/app/shared';

@Component({
  selector: 'app-modal-reprovar-cliente',
  templateUrl: './modal-reprovar-cliente.component.html',
  styleUrls: ['./modal-reprovar-cliente.component.scss'],
})
export class ModalReprovarClienteComponent {
  motivo?: string;

  constructor(@Inject(MAT_DIALOG_DATA) public cliente: Cliente) {}
}
