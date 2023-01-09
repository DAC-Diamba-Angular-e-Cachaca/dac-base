package com.bantads.orquestrador.bantadsorquestrador.services.Gerente;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.orquestrador.bantadsorquestrador.model.gerente.Gerente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderGerente {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueGerente;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Gerente gerente) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(gerente);
        this.template.convertAndSend(this.queueGerente.getName(), json);
    }
}
