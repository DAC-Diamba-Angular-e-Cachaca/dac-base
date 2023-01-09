import { Component, ElementRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Cliente } from 'src/app/shared';
import { ModalClienteComponent } from '../modal-cliente/modal-cliente.component';
import { GerenteService } from '../services';

@Component({
  selector: 'app-consultar-cliente',
  templateUrl: './consultar-cliente.component.html',
  styleUrls: ['./consultar-cliente.component.scss'],
})
export class ConsultarClienteComponent {
  clienteResultado: Cliente | undefined = undefined;

  @ViewChild('cpf') cpf!: ElementRef;

  constructor(
    private gerenteService: GerenteService,
    private modalService: MatDialog
  ) {}

  buscarPorCpf(cpf: string) {
    this.clienteResultado = this.gerenteService.buscarClientePorCpf(cpf);
    if (!!this.clienteResultado) {
      this.abrirModalCliente();
    }
  }

  abrirModalCliente() {
    const modal = this.modalService.open(ModalClienteComponent, {
      data: this.clienteResultado,
      width: '1000px',
    });
    modal.afterClosed().subscribe(() => {
      this.cpf.nativeElement.value = null;
      this.clienteResultado = undefined;
    })
  }
}
