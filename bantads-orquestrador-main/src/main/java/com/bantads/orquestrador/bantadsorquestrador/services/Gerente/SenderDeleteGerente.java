package com.bantads.orquestrador.bantadsorquestrador.services.Gerente;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderDeleteGerente {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueDeleteGerente;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(UUID id) throws JsonProcessingException {
        this.template.convertAndSend(this.queueDeleteGerente.getName(), id);
    }
}
