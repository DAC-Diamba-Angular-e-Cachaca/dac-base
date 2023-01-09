import { Analise } from './analise.model';
import { Conta } from './conta.model';
import { Endereco } from './endereco.model';
import { Usuario } from './usuario.model';

export class Cliente {
  constructor(
    public id?: string,
    public nome?: string,
    public cpf?: string,
    public usuario: Usuario = new Usuario(),
    public endereco: Endereco = new Endereco(),
    public conta: Conta = new Conta(),
    public salario: number = 0,
    public analise: Analise = new Analise(),
  ) {}
}
