package com.bantads.conta.bantadsconta.services.Consumer.AutoCadastro;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;

@Component
public class ConsumerRollback {
    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @RabbitListener(queues = "autocadastro-gerente-conta-rollback")
    public void receive(@Payload String json){
        try {
            UUID saga = UUID.fromString(json);
            gerenteContaRepository.deleteBySaga(saga);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
