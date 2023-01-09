import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Cliente, Estados } from 'src/app/shared';
import { ModalClienteComponent } from '../modal-cliente/modal-cliente.component';
import { GerenteService } from '../services/gerente.service';

@Component({
  selector: 'app-consultar-clientes',
  templateUrl: './consultar-clientes.component.html',
  styleUrls: ['./consultar-clientes.component.scss'],
})
export class ConsultarClientesComponent implements OnInit {
  displayedColumns: string[] = [
    'nome',
    'cpf',
    'estado',
    'cidade',
    'saldoAtual',
    'acoes',
  ];
  clientes: Cliente[] = [];

  constructor(
    private gerenteService: GerenteService,
    private modalService: MatDialog
  ) {}

  ngOnInit(): void {
    const clientes: Cliente[] = [];

    let cliente = new Cliente();
    cliente.id = new Date().getTime().toString();
    cliente.nome = 'Carlos';
    cliente.cpf = '111.111.111-11';
    cliente.endereco.estado = Estados.PARA;
    cliente.endereco.cidade = 'Curitiba';
    cliente.conta.saldo = 1587.65;
    cliente.endereco.cep = '800.50-550';
    cliente.endereco.logradouro = 'Nossa senhora da Penha';
    cliente.endereco.complemento = 'A';
    cliente.endereco.tipoEndereco = 'Avenida';
    cliente.endereco.numero = 21;
    cliente.salario = 4584.0;
    cliente.conta.limite = 21000;
    cliente.conta.numeroConta = '123354';
    cliente.usuario.email = 'carlos@hotmail.com';
    clientes.push(cliente);

    let cliente2 = new Cliente();
    cliente2.id = new Date().getTime().toString();
    cliente2.nome = 'Gabriel';
    cliente2.cpf = '234.687.153-44';
    cliente2.endereco.estado = Estados.SAO_PAULO;
    cliente2.endereco.cidade = 'Campinas';
    cliente2.conta.saldo = 23987.11;
    cliente2.endereco.cep = '800.50-550';
    cliente2.endereco.logradouro = 'Nossa senhora da Penha';
    cliente2.endereco.complemento = 'A';
    cliente2.endereco.tipoEndereco = 'Avenida';
    cliente2.endereco.numero = 21;
    cliente2.salario = 4584.0;
    cliente2.conta.limite = 48555;
    cliente2.conta.numeroConta = '123123';
    cliente2.usuario.email = 'gabriel@hotmail.com';
    clientes.push(cliente2);

    localStorage['clientes'] = JSON.stringify(clientes);

    this.clientes = this.gerenteService.listarTodos();
  }

  abrirModalCliente(cliente: Cliente) {
    const modalRef = this.modalService.open(ModalClienteComponent, {
      data: cliente,
      width: '1000px',
    });
  }

  filtrar(palavraChave: string) {
    this.clientes = this.gerenteService.listarTodos();
    if (palavraChave) {
      palavraChave = palavraChave.toUpperCase();
      this.clientes = this.clientes.filter(
        (c) => c.nome!.toUpperCase().indexOf(palavraChave) >= 0
      );
      if (this.clientes.length == 0) palavraChave = palavraChave.toUpperCase();
    } else {
      this.clientes = this.gerenteService.listarTodos();
    }
  }
}
