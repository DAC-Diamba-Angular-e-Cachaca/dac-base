package com.bantads.conta.bantadsconta.DTOs;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ContaDTO implements Serializable  {
	private UUID idCliente;
	private UUID idGerente;
	private BigDecimal salario;
	private UUID saga;
	
	public ContaDTO() {
		super();
	}
	
	public ContaDTO(UUID idCliente, BigDecimal salario, UUID saga) {
		super();
		this.idCliente = idCliente;
		this.salario = salario;
		this.saga = saga;
	}
	
	public UUID getIdCliente() {
		return this.idCliente;
	}
	
	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}
	
	public UUID getIdGerente() {
		return this.idCliente;
	}
	
	public void setIdGerente(UUID idCliente) {
		this.idCliente = idCliente;
	}
	
	public BigDecimal getSalario() {
		if(this.salario == null)
			return new BigDecimal("0");
		return this.salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public UUID getSaga() {
		return this.idCliente;
	}
	
	public void setSaga(UUID saga) {
		this.saga = saga;
	}
}