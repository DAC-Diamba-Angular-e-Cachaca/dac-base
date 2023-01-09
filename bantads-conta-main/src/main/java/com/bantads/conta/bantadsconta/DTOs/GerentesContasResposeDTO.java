package com.bantads.conta.bantadsconta.DTOs;

import java.util.List;

import com.bantads.conta.bantadsconta.model.R.GerenteConta;

public class GerentesContasResposeDTO {

	private List<GerenteConta> gerentesContas;
	
	public GerentesContasResposeDTO(List<GerenteConta> lista) {
		this.gerentesContas = lista;
	}
	
	public List<GerenteConta> getGerentesContas(){
		return this.gerentesContas;
	}
	
	public void setGerentesContas(List<GerenteConta> gerentesContas) {
		this.gerentesContas = gerentesContas;
	}
}
