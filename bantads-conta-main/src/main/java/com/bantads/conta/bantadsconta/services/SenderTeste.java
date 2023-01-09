package com.bantads.conta.bantadsconta.services;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bantads.conta.bantadsconta.DTOs.ContaDTO;
import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
@Component
public class SenderTeste {

	@Autowired                              
	private RabbitTemplate template;        
	                                        
	@Autowired                              
	private Queue queueInserirConta;        
	                                     
	 //simplemente pra eu ter um endpoint de teste(quem mandara pra ca será outro MS)        
	 public void sendInserir(ContaDTO conta) throws JsonProcessingException {           
		 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 String json = ow.writeValueAsString(conta);
	     this.template.convertAndSend(this.queueInserirConta.getName(), json);               
	 }                                                                                       
}
