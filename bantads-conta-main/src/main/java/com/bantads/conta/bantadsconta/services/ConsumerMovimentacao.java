package com.bantads.conta.bantadsconta.services;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.bantads.conta.bantadsconta.DTOs.MovimentacaoContaDTO;
import com.bantads.conta.bantadsconta.data.R.ContaRRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.data.R.MovimentacaoRRepository;
import com.bantads.conta.bantadsconta.model.R.ContaR;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;
import com.bantads.conta.bantadsconta.model.R.MovimentacaoR;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerMovimentacao {
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
    private ModelMapper mapper;
	
	@Autowired
    private MovimentacaoRRepository movimentacaoRRepository;

	@Autowired
    private ContaRRepository contaRRepository;
	
	@Autowired
	private GerenteContaRepository gerenteContaRepository;
	
	@RabbitListener(queues = "movimentacao-inserir")
    public void receive(@Payload String json) {
        try {
        	
        	MovimentacaoContaDTO mov = objectMapper.readValue(json, MovimentacaoContaDTO.class);
        	
        	MovimentacaoR movimentacao = mapper.map(mov.getMovimentacaoC(), MovimentacaoR.class);
        	movimentacaoRRepository.save(movimentacao);
        	
        	ContaR origem = mapper.map(mov.getOrigem(), ContaR.class);
        	contaRRepository.save(origem);
        	
        	if(mov.getDestino() != null) {
        		ContaR destino = mapper.map(mov.getDestino(), ContaR.class);
        		contaRRepository.save(destino);
        	}
        	
        	GerenteConta gerenteContaOrigem = gerenteContaRepository.findByIdExternoGerente(origem.getIdExternoGerente());
        	GerenteConta gerenteContaDestino = null;
        	
			gerenteContaOrigem.setSaldoPositivo(gerenteContaRepository.calculaSaldoPositivo(gerenteContaOrigem.getIdExternoGerente()));
			gerenteContaOrigem.setSaldoNegativo(gerenteContaRepository.calculaSaldoNegativo(gerenteContaOrigem.getIdExternoGerente()));
        	gerenteContaRepository.save(gerenteContaOrigem);
			
			if (mov.getDestino() != null) {
				gerenteContaDestino = gerenteContaRepository.findByIdExternoGerente(mov.getDestino().getIdExternoGerente());
				gerenteContaDestino.setSaldoPositivo(gerenteContaRepository.calculaSaldoPositivo(gerenteContaDestino.getIdExternoGerente()));
				gerenteContaDestino.setSaldoNegativo(gerenteContaRepository.calculaSaldoNegativo(gerenteContaDestino.getIdExternoGerente()));
				gerenteContaRepository.save(gerenteContaDestino);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
