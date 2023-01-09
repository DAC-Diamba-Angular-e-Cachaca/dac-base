package com.bantads.cliente.bantadscliente.DTOs;

import java.math.BigDecimal;
import java.util.UUID;

public class ClienteResponseDTO {
    private UUID id;
    private UUID idExternoUsuario;
    private String nome;
    private String cpf;
    private EnderecoResponseDTO endereco;
    private AnaliseResponseDTO analise;
    private BigDecimal salario;   

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(UUID id, UUID idExternoUsuario, String nome, String cpf, EnderecoResponseDTO endereco, AnaliseResponseDTO analise,
            BigDecimal salario) {
        this.id = id;
        this.idExternoUsuario = idExternoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.analise = analise;
        this.salario = salario;
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

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

    public AnaliseResponseDTO getAnalise() {
        return analise;
    }

    public void setAnalise(AnaliseResponseDTO analise) {
        this.analise = analise;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    } 
}
