package com.bantads.orquestrador.bantadsorquestrador.services.Cliente;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.orquestrador.bantadsorquestrador.model.cliente.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderCliente {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueCliente;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Cliente cliente) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(cliente);
        this.template.convertAndSend(this.queueCliente.getName(), json);
    }
}
