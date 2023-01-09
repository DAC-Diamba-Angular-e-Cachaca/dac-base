package com.bantads.cliente.bantadscliente.services.Producer.Aprovacao;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.DTOs.GerarSenhaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderGerarSenha {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueGerarSenhaCliente;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(GerarSenhaDTO gerarSenhaDTO) throws JsonProcessingException{
        String json = objectMapper.writeValueAsString(gerarSenhaDTO);
        this.template.convertAndSend(this.queueGerarSenhaCliente.getName(), json);
    }
}
