import { Estados } from './enum/estados';

export class Endereco {
  constructor(
    public id?: string,
    public logradouro?: string,
    public numero: number = 0,
    public complemento?: string,
    public bairro?: string,
    public cep?: string,
    public cidade?: string,
    public estado?: Estados,
    public tipoEndereco?: string // TODO colocar no diagrama de classes
  ) {}
}
