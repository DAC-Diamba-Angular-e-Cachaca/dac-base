import { Usuario } from '.';

export class Gerente {
  constructor(
    public usuario: Usuario = new Usuario(),
    public id?: string,
    public nome?: string,
    public cpf?: string,
    public quantidadeContas?: number,
    public saldoPositivo?: string,
    public saldoNegativo?: string
  ) {}
}
