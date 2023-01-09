package com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class SenderAutenticacao {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueRollbackAutocadastroAutenticacao;

    public void send(UUID saga) throws JsonProcessingException {
        this.template.convertAndSend(this.queueRollbackAutocadastroAutenticacao.getName(), saga);
    }
}