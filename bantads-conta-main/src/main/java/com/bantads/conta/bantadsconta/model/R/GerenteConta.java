package com.bantads.conta.bantadsconta.model.R;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gerenteconta")
public class GerenteConta {
    private UUID id;
    private UUID idExternoGerente;
    private int quantidadeContas;
    private BigDecimal saldoPositivo;
    private BigDecimal saldoNegativo;
    private boolean ativo;
    private UUID saga;

    public GerenteConta() {
        super();
    }

    public GerenteConta(UUID id, UUID idExternoGerente, int quantidadeContas, BigDecimal saldoPositivo,
            BigDecimal saldoNegativo, boolean ativo, UUID saga) {
        super();
        this.id = id;
        this.idExternoGerente = idExternoGerente;
        this.quantidadeContas = quantidadeContas;
        this.saldoPositivo = saldoPositivo;
        this.saldoNegativo = saldoNegativo;
        this.ativo = ativo;
        this.saga = saga;
    }

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "idexternogerente")
    public UUID getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(UUID idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

    @Column(name = "quantidadecontas")
    public int getQuantidadeContas() {
        return quantidadeContas;
    }

    public void setQuantidadeContas(int quantidadeContas) {
        this.quantidadeContas = quantidadeContas;
    }

    @Column(name = "saldopositivo")
    public BigDecimal getSaldoPositivo() {
        return saldoPositivo;
    }

    public void setSaldoPositivo(BigDecimal saldoPositivo) {
        this.saldoPositivo = saldoPositivo;
    }

    public void setSaldoPositivo(double saldoPositivo) {
        this.saldoPositivo = new BigDecimal(saldoPositivo);
    }

    @Column(name = "saldonegativo")
    public BigDecimal getSaldoNegativo() {
        return saldoNegativo;
    }

    public void setSaldoNegativo(BigDecimal saldoNegativo) {
        this.saldoNegativo = saldoNegativo;
    }

    public void setSaldoNegativo(double saldoNegativo) {
        this.saldoNegativo = new BigDecimal(saldoNegativo);
    }

    @Column(name = "saga")
    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

    @Column(name = "ativo")
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
