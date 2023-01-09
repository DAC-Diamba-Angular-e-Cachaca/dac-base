package com.bantads.cliente.bantadscliente.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private UUID id;
    private UUID idExternoUsuario;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Analise analise;
    private BigDecimal salario;
    private UUID saga;

    public Cliente() {
        super();
    }

    public Cliente(UUID id, UUID idExternoUsuario, String nome, String cpf, Endereco endereco, Analise analise, BigDecimal salario,
            UUID saga) {
        super();
        this.id = id;
        this.idExternoUsuario = idExternoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.analise = analise;
        this.salario = salario;
        this.saga = saga;
    }

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "idexternousuario")
    public UUID getIdExternoUsuario() {
        return idExternoUsuario;
    }

    public void setIdExternoUsuario(UUID idExternoUsuario) {
        this.idExternoUsuario = idExternoUsuario;
    }

    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idendereco", referencedColumnName = "id")
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idanalise", referencedColumnName = "id")
    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    @Column(name = "salario")
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Column(name = "saga")
    public UUID getSaga() {
        return saga;
    }

    public void setSaga(UUID saga) {
        this.saga = saga;
    }

}
