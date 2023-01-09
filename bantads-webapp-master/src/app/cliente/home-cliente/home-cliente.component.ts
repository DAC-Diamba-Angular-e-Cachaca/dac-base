import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Cliente, Conta, Gerente, Movimentacao } from 'src/app/shared/models';
import { ClienteService } from '../services';

@Component({
  selector: 'app-home-cliente',
  templateUrl: './home-cliente.component.html',
  styleUrls: ['./home-cliente.component.scss'],
})
export class HomeClienteComponent implements OnInit {
  loading!: boolean;

  cliente: Cliente = new Cliente();
  conta: Conta = new Conta();
  gerente: Gerente = new Gerente();
  movimentacao: Movimentacao = new Movimentacao();

  constructor(
    private clienteService: ClienteService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.cliente = this.clienteService.getCliente();
    this.conta = this.clienteService.getConta();
    this.gerente = this.clienteService.getGerenteResponsavel();
  }

  depositar(valorDeposito: string): void {
    console.log('deposito: ' + valorDeposito);
    valorDeposito = valorDeposito.replace('R$', '');
    valorDeposito = valorDeposito.replace('.', '');
    valorDeposito = valorDeposito.replace(',', '.');

    this.loading = true;

    this.movimentacao.id = Math.random().toString();
    this.movimentacao.valorMovimentacao = parseFloat(valorDeposito);
    this.movimentacao.dataHora = new Date().toString();
    this.movimentacao.tipo = 1;
    this.movimentacao.origem = undefined;
    this.movimentacao.destino = undefined;

    this.conta.saldo += parseFloat(valorDeposito);
    this.toastr.success('Depósito efetuado.');

    this.clienteService.inserir(this.movimentacao).subscribe((movimentacao) => {
      this.loading = false;
    });
  }

  sacar(valorSaque: string): void {
    console.log('saque: ' + valorSaque);
    valorSaque = valorSaque.replace('R$', '');
    valorSaque = valorSaque.replace('.', '');
    valorSaque = valorSaque.replace(',', '.');

    if (parseFloat(valorSaque) <= (this.conta.saldo + this.conta.limite)) {
      this.loading = true;

      this.movimentacao.id = Math.random().toString();
      this.movimentacao.valorMovimentacao = parseFloat(valorSaque);
      this.movimentacao.dataHora = new Date().toString();
      this.movimentacao.tipo = 2;
      this.movimentacao.origem = undefined;
      this.movimentacao.destino = undefined;

      this.conta.saldo -= parseFloat(valorSaque);
      this.toastr.success('Saque efetuado.');

      this.clienteService
        .inserir(this.movimentacao)
        .subscribe((movimentacao) => {
          this.loading = false;
        });
    } else {
      this.toastr.error('Saldo insuficiente.');
    }
  }

  transferir(contaDestino: string, valorTransferencia: string): void {
    console.log('transferencia: ' + contaDestino + '/' + valorTransferencia);
    valorTransferencia = valorTransferencia.replace('R$', '');
    valorTransferencia = valorTransferencia.replace('.', '');
    valorTransferencia = valorTransferencia.replace(',', '.');

    if (parseFloat(valorTransferencia) <= (this.conta.saldo + this.conta.limite)) {
      this.loading = true;

      this.movimentacao.id = Math.random().toString();
      this.movimentacao.valorMovimentacao = parseFloat(valorTransferencia);
      this.movimentacao.dataHora = new Date().toString();
      this.movimentacao.tipo = 3;
      this.movimentacao.origem = undefined;
      this.movimentacao.destino = new Conta(contaDestino, 0, '', 0);

      this.conta.saldo -= parseFloat(valorTransferencia);
      this.toastr.success('Transferência realizada com sucesso.');

      this.clienteService
        .inserir(this.movimentacao)
        .subscribe((movimentacao) => {
          this.loading = false;
        });
    } else {
      this.toastr.error('Saldo insuficiente.');
    }
  }
}
