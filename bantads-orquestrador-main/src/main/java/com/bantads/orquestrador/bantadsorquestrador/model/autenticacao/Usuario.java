package com.bantads.orquestrador.bantadsorquestrador.model.autenticacao;

import java.io.Serializable;
import java.util.UUID;

public class Usuario implements Serializable {
    private UUID id;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private UUID saga;

    public Usuario() {
        super();
    }

    public Usuario(UUID id, String senha, String email, TipoUsuario tipoUsuario, UUID saga) {
        super();
        this.id = id;
        this.senha = senha;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.saga = saga;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
