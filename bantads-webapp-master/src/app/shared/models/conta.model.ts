import { Gerente } from "./gerente.model";

export class Conta {
    constructor(
        public numeroConta?: string, // TODO atualizar diagrama classes
        public saldo: number = 0,
        public dataCriacao?: string,
        public limite: number = 0,
        public gerente?: Gerente
    ) {}
}
