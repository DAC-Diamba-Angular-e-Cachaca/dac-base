package com.bantads.conta.bantadsconta.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class MovimentacaoDTO {

	private UUID id;
	private BigDecimal valor;
	private int tipoMovimentacao;
	private UUID origem;
	private int destino;
	private UUID saga;
	private Date datahora;
	
	public MovimentacaoDTO() {
		
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public int getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}
	
	public void setTipoMovimentacao(int tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
	public UUID getOrigem() {
		return this.origem;
	}
	
	public void setOrigem(UUID origem) {
		this.origem = origem;
	}
	
	public int getDestino() {
		return this.destino;
	}
	
	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	public UUID getSaga() {
		return this.saga;
	}
	
	public void setSaga(UUID saga) {
		this.saga = saga;
	}
	
	public Date getDataHora() {
		return this.datahora;
	}
	
	public void setDataHora(Date dataHora) {
		this.datahora = dataHora;
	}
}
