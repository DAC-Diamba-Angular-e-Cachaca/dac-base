package com.bantads.orquestrador.bantadsorquestrador.DTOs;

public class GerenteDTO {
    private String nome;
    private String cpf;
    private UsuarioDTO usuario;

    public GerenteDTO() {
    }

    public GerenteDTO(String nome, String cpf, UsuarioDTO usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

}
