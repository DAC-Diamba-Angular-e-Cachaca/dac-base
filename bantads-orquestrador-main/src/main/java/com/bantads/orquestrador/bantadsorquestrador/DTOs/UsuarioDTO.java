package com.bantads.orquestrador.bantadsorquestrador.DTOs;

import com.bantads.orquestrador.bantadsorquestrador.model.autenticacao.TipoUsuario;

public class UsuarioDTO {
    private String senha;
    private String email;
    private TipoUsuario tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String senha, String email, TipoUsuario tipoUsuario) {
        this.senha = senha;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
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

}
