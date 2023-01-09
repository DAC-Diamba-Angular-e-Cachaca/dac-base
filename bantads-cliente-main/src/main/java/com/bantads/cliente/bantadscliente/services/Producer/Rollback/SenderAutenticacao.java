package com.bantads.cliente.bantadscliente.services.Producer.Rollback;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderAutenticacao {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueRollbackAutocadastroAutenticacao;

    public void send(UUID saga) {
        this.template.convertAndSend(this.queueRollbackAutocadastroAutenticacao.getName(), saga);
    }
}
