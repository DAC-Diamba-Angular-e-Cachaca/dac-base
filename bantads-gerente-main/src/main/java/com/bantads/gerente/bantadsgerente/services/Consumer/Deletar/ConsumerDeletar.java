package com.bantads.gerente.bantadsgerente.services.Consumer.Deletar;

import java.util.Optional;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.gerente.bantadsgerente.data.GerenteRepository;
import com.bantads.gerente.bantadsgerente.model.Gerente;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao.SenderDeleteUsuario;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao.SenderRollbackDeleteUsuario;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta.SenderRollbackDeleteGerenteConta;

@Component
public class ConsumerDeletar {
    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private SenderDeleteUsuario senderDeleteUsuario;

    @Autowired
    private SenderRollbackDeleteUsuario senderRollbackDeleteUsuario;

    @Autowired
    private SenderRollbackDeleteGerenteConta senderRollbackDeleteGerenteConta;

    @RabbitListener(queues = "delete-gerente")
    public void receive(@Payload String json) {
        try {
            UUID id = UUID.fromString(json);
            Optional<Gerente> gerenteOp = gerenteRepository.findById(id);
            Gerente gerente = gerenteOp.get();
            gerente.setAtivo(false);
            senderDeleteUsuario.send(gerente.getIdExternoUsuario());
            gerenteRepository.save(gerente);
        } catch (Exception e) {
            System.out.println(e);
            UUID id = UUID.fromString(json);
            Optional<Gerente> gerenteOp = gerenteRepository.findById(id);
            Gerente gerente = gerenteOp.get();
            senderRollbackDeleteUsuario.send(gerente.getIdExternoUsuario());
            senderRollbackDeleteGerenteConta.send(gerente.getId());
        }
    }
}
