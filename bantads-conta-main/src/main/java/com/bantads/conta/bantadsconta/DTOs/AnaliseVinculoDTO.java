package com.bantads.conta.bantadsconta.DTOs;

import java.util.UUID;

public class AnaliseVinculoDTO {
    private UUID id;
    private UUID idExternoGerente;

    public AnaliseVinculoDTO() {
    }

    public AnaliseVinculoDTO(UUID id, UUID idExternoGerente) {
        this.id = id;
        this.idExternoGerente = idExternoGerente;
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

}
