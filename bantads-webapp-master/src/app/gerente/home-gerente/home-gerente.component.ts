import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/shared';
import { ModalReprovarClienteComponent } from '../modal-reprovar-cliente/modal-reprovar-cliente.component';
import { GerenteService } from '../services';

@Component({
  selector: 'app-home-gerente',
  templateUrl: './home-gerente.component.html',
  styleUrls: ['./home-gerente.component.scss'],
})
export class HomeGerenteComponent implements OnInit {
  displayedColumns: string[] = ['nome', 'cpf', 'salarioMensal', 'acoes'];
  clientesPendentes: Cliente[] = [];

  constructor(
    private gerenteService: GerenteService,
    private modalService: MatDialog,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    // Para iniciar tela - retirar
    this.gerenteService.adicionaUm();

    this.clientesPendentes = this.gerenteService.listarAprovacoesPendentes();
  }

  async aprovar($event: any, cliente: Cliente): Promise<void> {
    // $event.preventDefault();
    if (await confirm('Confirma a aprovação do cliente ' + cliente.nome + '?')) {
      this.gerenteService.aprovarCliente(cliente);
      this.clientesPendentes = this.gerenteService.listarAprovacoesPendentes();
      this.toastr.success('Cliente aprovado.');
    }
  }

  reprovar($event: any, cliente: Cliente): void {
    $event.preventDefault();
    const modalRef = this.modalService.open(ModalReprovarClienteComponent, {
      data: cliente,
      width: '1000px',
    });
    modalRef.afterClosed().subscribe((motivo: string) => {
      if (motivo?.length > 0) {
        this.gerenteService.reprovarCliente(cliente);
        this.clientesPendentes =
          this.gerenteService.listarAprovacoesPendentes();
        this.toastr.success('Mensagem enviada ao cliente.');
      }
    });
  }
}
