package com.bantads.conta.bantadsconta.DTOs;

import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.bantads.conta.bantadsconta.model.CUD.MovimentacaoC;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;

public class MovimentacaoContaDTO {

	private MovimentacaoC movimentacao;
	private ContaC origem;
	private ContaC destino;
	
	public MovimentacaoContaDTO() {
		
	}
	
	public MovimentacaoContaDTO(MovimentacaoC mov, ContaC origem, ContaC destino) {
		this.movimentacao = mov;
		this.origem = origem;
		this.destino = destino;
	}
	
	public MovimentacaoC getMovimentacaoC() {
		return this.movimentacao;
	}
	
	public void setMovimentacaoC(MovimentacaoC movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	public ContaC getOrigem() {
		return this.origem;
	}
	
	public void setOrigem(ContaC origem) {
		this.origem = origem;
	}
	
	public ContaC getDestino() {
		return this.destino;
	}
	
	public void setDestino(ContaC destino) {
		this.destino = destino;
	}
}
