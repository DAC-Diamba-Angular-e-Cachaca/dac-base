package com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderNovaSenha {
    @Autowired
    private RabbitTemplate template;
    
    @Autowired
    private Queue queueRollbackNovaSenha;

    public void send(UUID saga){
        this.template.convertAndSend(this.queueRollbackNovaSenha.getName(), saga);
    }
}
