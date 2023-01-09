package com.bantads.conta.bantadsconta.model;

public enum TipoMovimentacao {
    Deposito(1), Saque(2), Transferencia(3);
    
    private int valor;

    TipoMovimentacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
