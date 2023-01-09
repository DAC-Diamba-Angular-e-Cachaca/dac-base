package com.bantads.orquestrador.bantadsorquestrador.model.gerente;

import java.io.Serializable;
import java.util.UUID;

public class Gerente implements Serializable {
    private UUID id;
    private UUID idExternoUsuario;
    private String nome;
    private String cpf;
    private UUID saga;

    public Gerente() {
        super();
    }

    public Gerente(UUID id, UUID idExternoUsuario, String nome, String cpf, UUID saga) {
        super();
        this.id = id;
        this.idExternoUsuario = idExternoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.saga = saga;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdExternoUsuario() {
        return idExternoUsuario;
    }

    public void setIdExternoUsuario(UUID idExternoUsuario) {
        this.idExternoUsuario = idExternoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
