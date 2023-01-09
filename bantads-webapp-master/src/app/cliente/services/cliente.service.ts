import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  Cliente,
  Conta,
  Endereco,
  Estados,
  Gerente,
  Movimentacao,
  TipoUsuario,
  Usuario,
} from 'src/app/shared/models';

const LS_CLIENTE: string = 'cliente';
const LS_CONTA: string = 'conta';
const LS_GERENTE_RESPONSAVEL: string = 'gerenteResponsavel';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  BASE_URL = 'http://localhost:3000/movimentacao/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private httpClient: HttpClient) {}

  getCliente(): Cliente {
    //teste - retirar
    localStorage[LS_CLIENTE] = JSON.stringify(
      new Cliente(
        new Date().getTime().toString(),
        'Felipe Correa',
        '100.200.300-40',
        new Usuario('54', 'felipe@mail.com', 'senha', TipoUsuario.Cliente),
        new Endereco(
          new Date().getTime().toString(),
          'Rua Parana',
          277,
          'AP55',
          'Boa Vista',
          '82510420',
          'Curitiba',
          Estados.PARA
        ),
        new Conta(),
        4500.45
      )
    );

    return JSON.parse(localStorage[LS_CLIENTE]) as Cliente;
  }

  getConta(): Conta {
    //teste - retirar
    localStorage[LS_CONTA] = JSON.stringify(
      new Conta('1243', 777.88, '01/07/2022', 2000.0)
    );

    return JSON.parse(localStorage[LS_CONTA]) as Conta;
  }

  getGerenteResponsavel(): Gerente {
    //teste - retirar
    localStorage[LS_GERENTE_RESPONSAVEL] = JSON.stringify(
      new Gerente(
        new Usuario('54', 'fcarvalho@bantads.com.br', 'senha', TipoUsuario.Gerente),
        new Date().getHours().toString(),
        'Fernando Carvalho',
        '200.300.400-50',
        12,
        '2412.33',
        '4243.88'
      )
    );

    return JSON.parse(localStorage[LS_GERENTE_RESPONSAVEL]) as Gerente;
  }

  getMovimentacaoPeriodo(): Observable<Movimentacao[]> {
    return this.httpClient.get<Movimentacao[]>(this.BASE_URL, this.httpOptions);
  }

  /*buscarPorId(id: number): Observable<Conta> {
    return this.httpClient.get<Conta>(this.BASE_URL + id, this.httpOptions);
  }*/

  inserir(Movimentacao: Movimentacao): Observable<Movimentacao> {
    return this.httpClient.post<Movimentacao>(
      this.BASE_URL,
      JSON.stringify(Movimentacao),
      this.httpOptions
    );
  }

  /*remover(id: number): Observable<Conta> {
      return this.httpClient.delete<Conta>(this.BASE_URL + id,this.httpOptions);
  }
      
  alterar(Conta: Conta): Observable<Conta> {
      return this.httpClient.put<Conta>(this.BASE_URL + Conta.id, JSON.stringify(Conta), this.httpOptions);
  }*/
}
