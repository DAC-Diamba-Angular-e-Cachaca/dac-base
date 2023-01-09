import { Injectable } from '@angular/core';
import { Cliente, Conta, Endereco, Estados, Usuario } from 'src/app/shared';

const LS_CHAVE: string = 'clientes';
const LS_CHAVE_CLIENTES_PENDENTES: string = 'clientesAutocadastro';

@Injectable({
  providedIn: 'root',
})
export class GerenteService {
  constructor() {}

  // TODO RETIRAR DEPOIS
  adicionaUm() {
    const cliente = new Cliente(
      new Date().getTime().toString(),
      'Fulana de Tal',
      '451.454.121-54',
      new Usuario('fulana@mail.com', 'senha'),
      new Endereco(
        new Date().toString(),
        'Rua XV',
        20,
        '',
        'Centro',
        '82414111',
        'Curitiba',
        Estados.PARANA,
        'Residencial'
      ),
      new Conta(),
      2340
    );
    const clientes = this.listarAprovacoesPendentes();
    clientes.push(cliente);
    localStorage[LS_CHAVE_CLIENTES_PENDENTES] = JSON.stringify(clientes);
  }

  listarTodos(): Cliente[] {
    const clientes = localStorage[LS_CHAVE];
    return clientes ? JSON.parse(clientes) : [];
  }

  listarAprovacoesPendentes(): Cliente[] {
    const clientes = localStorage[LS_CHAVE_CLIENTES_PENDENTES];
    return clientes ? JSON.parse(localStorage[LS_CHAVE_CLIENTES_PENDENTES]) : [];
  }

  aprovarCliente(cliente: Cliente) {
    let clientes = this.listarAprovacoesPendentes();
    clientes = clientes.filter((c) => c.id !== cliente.id);
    localStorage[LS_CHAVE_CLIENTES_PENDENTES] = JSON.stringify(clientes);

    clientes = this.listarTodos();
    clientes.push(cliente);
    localStorage[LS_CHAVE] = JSON.stringify(clientes);
  }

  reprovarCliente(cliente: Cliente) {
    let clientes = this.listarAprovacoesPendentes();
    clientes = clientes.filter((c) => c.id !== cliente.id);
    localStorage[LS_CHAVE_CLIENTES_PENDENTES] = JSON.stringify(clientes);
  }

  buscarClientePorCpf(value: string): Cliente | undefined {
    const cpf = value.replace(/[^0-9]/g, ''); // Deixa apenas numeros

    return this.listarTodos().find((c) => c.cpf?.replace(/[^0-9]/g, '') === cpf);
  }

  listarMelhoresClientes(): Cliente[] {
    let clientes = this.listarTodos();
    return clientes.sort((a, b) => b.conta.saldo - a.conta.saldo).slice(0, 5);
  }
}
