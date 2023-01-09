package com.bantads.cliente.bantadscliente.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "analise")
public class Analise implements Serializable {
    private UUID id;
    private String motivo;
    private boolean aprovacao;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private UUID idExternoGerente;
    private UUID saga;

    public Analise() {
        super();
    }

    public Analise(UUID id, String motivo, boolean aprovacao, LocalDateTime dataHora, Cliente cliente,
            UUID idExternoGerente, UUID saga) {
        super();
        this.id = id;
        this.motivo = motivo;
        this.aprovacao = aprovacao;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.idExternoGerente = idExternoGerente;
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

    @Column(name = "motivo")
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Column(name = "aprovado")
    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Column(name = "datahora")
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @OneToOne(mappedBy = "analise", cascade = CascadeType.ALL)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "idexternogerente")
    public UUID getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(UUID idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

    @Column(name = "saga")
    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
