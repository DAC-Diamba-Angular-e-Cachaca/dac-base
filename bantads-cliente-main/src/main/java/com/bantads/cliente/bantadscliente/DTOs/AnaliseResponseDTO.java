package com.bantads.cliente.bantadscliente.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public class AnaliseResponseDTO {
    private UUID id;
    private String motivo;
    private boolean aprovacao;
    private LocalDateTime dataHora;
    private UUID idExternoGerente;

    public AnaliseResponseDTO() {
    }

    public AnaliseResponseDTO(UUID id, String motivo, boolean aprovacao, LocalDateTime dataHora, UUID idExternoGerente) {
        this.id = id;
        this.motivo = motivo;
        this.aprovacao = aprovacao;
        this.dataHora = dataHora;
        this.idExternoGerente = idExternoGerente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public UUID getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(UUID idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

}
