package com.bantads.conta.bantadsconta.services.Consumer.Cliente;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.AnaliseVinculoDTO;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;
import com.bantads.conta.bantadsconta.services.Producer.Cliente.SenderAnaliseVinculo;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Cliente.SenderAnalise;

@Component
public class ConsumerAnalise {
    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @Autowired
    private SenderAnalise senderAnalise;

    @Autowired
    private SenderAnaliseVinculo senderAnaliseVinculo;

    @RabbitListener(queues = "analise-gerente")
    public void receive(@Payload String json) {
        try {
            UUID saga = UUID.fromString(json);
            GerenteConta gerente = gerenteContaRepository.getGerenteContaMenosContas().get(0);
            AnaliseVinculoDTO analiseVinculoDTO = new AnaliseVinculoDTO(saga, gerente.getIdExternoGerente());
            senderAnaliseVinculo.send(analiseVinculoDTO);
        } catch (Exception e) {
            System.out.println(e);
            UUID saga = UUID.fromString(json);
            senderAnalise.send(saga);
        }
    }
}
