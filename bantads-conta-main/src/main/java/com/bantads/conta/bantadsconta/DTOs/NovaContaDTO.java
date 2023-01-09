package com.bantads.conta.bantadsconta.DTOs;

import java.math.BigDecimal;
import java.util.UUID;

public class NovaContaDTO {
    private UUID idExternoCliente;
    private UUID idExternoGerente;
    private BigDecimal salario;
    private UUID saga;

    public NovaContaDTO() {
    }

    public NovaContaDTO(UUID idExternoCliente, UUID idExternoGerente, BigDecimal salario, UUID saga) {
        this.idExternoCliente = idExternoCliente;
        this.idExternoGerente = idExternoGerente;
        this.salario = salario;
        this.saga = saga;
    }

    public UUID getIdExternoCliente() {
        return idExternoCliente;
    }

    public void setIdExternoCliente(UUID idExternoCliente) {
        this.idExternoCliente = idExternoCliente;
    }

    public UUID getIdExternoGerente() {
        return idExternoGerente;
    }

    public void setIdExternoGerente(UUID idExternoGerente) {
        this.idExternoGerente = idExternoGerente;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
