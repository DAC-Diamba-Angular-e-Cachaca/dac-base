package com.bantads.conta.bantadsconta.DTOs;

import java.math.BigDecimal;
import java.util.UUID;

public class MovimentacaoResponseDTO {
	private UUID id;
    private UUID origem;
    private UUID destino;
    private BigDecimal valor;
    private int tipoMovimentacao;

    public MovimentacaoResponseDTO() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrigem() {
        return origem;
    }

    public void setOrigem(UUID contaOrigem) {
        this.origem = contaOrigem;
    }
    
    public UUID getDestino() {
        return destino;
    }

    public void setDestino(UUID contaDestino) {
        this.destino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valorMovimentacao) {
        this.valor = valorMovimentacao;
    }

    public int getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public void setTipoMovimentacao(int tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
