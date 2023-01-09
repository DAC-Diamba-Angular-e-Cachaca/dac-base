package com.bantads.conta.bantadsconta.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.amqp.core.Queue;
@Component
public class SenderConta {

	@Autowired
    private RabbitTemplate template;
	
	@Autowired
    private Queue queueInserirContaRead;
	
	public void sendInserirRead(ContaC conta) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(conta);             
        this.template.convertAndSend(this.queueInserirContaRead.getName(), json);
    }
}
