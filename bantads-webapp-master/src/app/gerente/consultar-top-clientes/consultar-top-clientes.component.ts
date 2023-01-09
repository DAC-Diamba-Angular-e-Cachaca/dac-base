import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/shared';
import { GerenteService } from '../services';

@Component({
  selector: 'app-consultar-top-clientes',
  templateUrl: './consultar-top-clientes.component.html',
  styleUrls: ['./consultar-top-clientes.component.scss'],
})
export class ConsultarTopClientesComponent implements OnInit {
  melhoresClientes: Cliente[] = [];
  displayedColumns: string[] = [
    'nome',
    'cpf',
    'cidade',
    'estado',
    'saldoAtual',
  ];

  constructor(private gerenteService: GerenteService) {}

  ngOnInit(): void {
    this.melhoresClientes = this.gerenteService.listarMelhoresClientes();
  }
}
