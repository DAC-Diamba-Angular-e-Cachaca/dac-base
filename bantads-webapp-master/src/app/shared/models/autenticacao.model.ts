import { Usuario } from "./usuario.model";

export class Autenticacao {
  constructor(
    public usuario: Usuario = new Usuario,
    public token?: string
  ) {}
}
