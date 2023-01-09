import { TipoUsuario } from "./enum/tipo-usuario";

export class Usuario {
  constructor(
    public id?: string,
    public email?: string,
    public senha?: string,
    public tipoUsuario: TipoUsuario = TipoUsuario.Cliente
  ) {}
}
