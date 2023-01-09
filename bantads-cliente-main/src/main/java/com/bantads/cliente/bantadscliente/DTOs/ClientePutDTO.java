package com.bantads.cliente.bantadscliente.DTOs;

import java.math.BigDecimal;

public class ClientePutDTO {
    private String nome;
    private EnderecoPutDTO endereco;
    private BigDecimal salario;

    public ClientePutDTO() {
    }

    public ClientePutDTO(String nome, EnderecoPutDTO endereco, BigDecimal salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoPutDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoPutDTO endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
