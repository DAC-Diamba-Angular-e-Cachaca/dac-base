import { Cliente } from './cliente.model';
import { Aprovacao } from './enum/aprovacao';
import { Gerente } from './gerente.model';

export class Analise {
  constructor(
    public id?: string,
    public aprovacao: Aprovacao = Aprovacao.Pendente,
    public motivo?: string,
    public dataHora?: Date,
    public cliente?: Cliente,
    public gerente?: Gerente
  ) {}
}
