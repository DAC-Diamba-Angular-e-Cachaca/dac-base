import { Conta } from './conta.model';
import { TipoMovimentacao } from './enum';

export class Movimentacao {
  constructor(
    public id?: string,
    public valorMovimentacao?: number,
    public dataHora?: string,
    public tipo?: TipoMovimentacao,
    public origem?: Conta,
    public destino?: Conta | undefined
  ) {}
}
