package com.bantads.orquestrador.bantadsorquestrador.DTOs;

import java.math.BigDecimal;

public class ClienteDTO {
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private BigDecimal salario;
    private UsuarioDTO usuario;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String cpf, EnderecoDTO endereco, BigDecimal salario, UsuarioDTO usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

}
