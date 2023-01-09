package com.bantads.gerente.bantadsgerente.services.Consumer.Deletar;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.gerente.bantadsgerente.data.GerenteRepository;
import com.bantads.gerente.bantadsgerente.model.Gerente;

@Component
public class ConsumerRollbackDeletar {
    @Autowired
    private GerenteRepository gerenteRepository;

    @RabbitListener(queues = "delete-gerente-rollback")
    public void receive(@Payload String json) {
        try {
            UUID id = UUID.fromString(json);
            Gerente gerente = gerenteRepository.findByIdExternoUsuario(id);
            gerente.setAtivo(true);
            gerenteRepository.save(gerente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
