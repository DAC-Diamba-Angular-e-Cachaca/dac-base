package com.bantads.orquestrador.bantadsorquestrador.services.Autenticacao;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.orquestrador.bantadsorquestrador.model.autenticacao.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderAutenticacao {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueAutenticacao;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Usuario usuario) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(usuario);
        this.template.convertAndSend(this.queueAutenticacao.getName(), json);
    }
}
