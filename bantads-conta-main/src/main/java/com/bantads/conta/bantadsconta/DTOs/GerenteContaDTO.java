package com.bantads.conta.bantadsconta.DTOs;

import java.math.BigDecimal;
import java.util.UUID;

public class GerenteContaDTO {
	private UUID id;
    private UUID idExternoGerente;
    private int quantidadeContas;
    private BigDecimal saldoPositivo;
    private BigDecimal saldoNegativo;
    private UUID saga;

    public GerenteContaDTO() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(UUID idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

    public int getQuantidadeContas() {
        return quantidadeContas;
    }

    public void setQuantidadeContas(int quantidadeContas) {
        this.quantidadeContas = quantidadeContas;
    }
    
    public BigDecimal getSaldoPositivo() {
        return saldoPositivo;
    }

    public void setSaldoPositivo(BigDecimal saldoPositivo) {
        this.saldoPositivo = saldoPositivo;
    }

    public BigDecimal getSaldoNegativo() {
        return saldoNegativo;
    }

    public void setSaldoNegativo(BigDecimal saldoNegativo) {
        this.saldoNegativo = saldoNegativo;
    }

    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }
}
