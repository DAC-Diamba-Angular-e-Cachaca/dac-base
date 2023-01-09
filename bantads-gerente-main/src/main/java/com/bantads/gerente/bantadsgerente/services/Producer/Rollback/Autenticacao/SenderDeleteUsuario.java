package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderDeleteUsuario {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueDeleteUsuario;

    public void send(UUID id) {
        this.template.convertAndSend(this.queueDeleteUsuario.getName(), id);
    }
}
