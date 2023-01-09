package com.bantads.cliente.bantadscliente.services.Producer.Aprovacao;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.DTOs.NovaContaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderNovaConta {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueNovaConta;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(NovaContaDTO novaContaDTO) throws JsonProcessingException{
        String json = objectMapper.writeValueAsString(novaContaDTO);
        this.template.convertAndSend(this.queueNovaConta.getName(), json);
    }
}
