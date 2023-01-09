package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderRollbackDeleteGerenteConta {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueRollbackDeleteGerenteConta;

    public void send(UUID id) {
        this.template.convertAndSend(this.queueRollbackDeleteGerenteConta.getName(), id);
    }
}
