package com.bantads.gerente.bantadsgerente.services.Consumer.Cadastro;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.gerente.bantadsgerente.data.GerenteRepository;

@Component
public class ConsumerRollback {
    @Autowired
    private GerenteRepository gerenteRepository;

    @RabbitListener(queues = "autocadastro-gerente-rollback")
    public void receive(@Payload String json) {
        try{
            UUID saga = UUID.fromString(json);
            gerenteRepository.deleteBySaga(saga);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
