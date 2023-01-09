package com.bantads.conta.bantadsconta.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.MovimentacaoContaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
@Component
public class SenderMovimentacao {
	@Autowired
    private RabbitTemplate template;
	
	@Autowired
    private Queue queueInserirMovimentacaoRead;
	
	public void sendInserirRead(MovimentacaoContaDTO mov) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(mov);             
        this.template.convertAndSend(this.queueInserirMovimentacaoRead.getName(), json);
    }
}
