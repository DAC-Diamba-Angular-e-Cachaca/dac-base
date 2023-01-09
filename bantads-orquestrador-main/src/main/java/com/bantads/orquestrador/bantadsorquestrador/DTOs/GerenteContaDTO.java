package com.bantads.orquestrador.bantadsorquestrador.DTOs;

import java.util.UUID;

public class GerenteContaDTO {
    private UUID id;
    private UUID saga;

    public GerenteContaDTO() {
    }

    public GerenteContaDTO(UUID id, UUID saga) {
        this.id = id;
        this.saga = saga;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
