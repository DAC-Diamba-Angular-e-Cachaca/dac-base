package com.bantads.orquestrador.bantadsorquestrador.model.cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Cliente implements Serializable {
    private UUID id;
    private UUID idExternoUsuario;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private BigDecimal salario;
    private UUID saga;

    public Cliente() {
        super();
    }

    public Cliente(UUID id, UUID idExternoUsuario, String nome, String cpf, Endereco endereco, BigDecimal salario,
            UUID saga) {
        super();
        this.id = id;
        this.idExternoUsuario = idExternoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
