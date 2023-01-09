package com.bantads.conta.bantadsconta.DTOs;

import java.util.List;

import com.bantads.conta.bantadsconta.model.R.MovimentacaoR;

public class MovimentacoesResponseDTO {

	private List<MovimentacaoR> movimentacoes;
	
	public MovimentacoesResponseDTO(List<MovimentacaoR> movs) {
		this.movimentacoes = movs;
	}
	
	public List<MovimentacaoR> getMovimentacoes() {
		return this.movimentacoes;
	}
	
	public void setMovimentacoes(List<MovimentacaoR> movs) {
		this.movimentacoes = movs;
	}
	
}
