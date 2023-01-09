package com.bantads.cliente.bantadscliente.services.Consumer.AnaliseVinculo;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.DTOs.AnaliseVinculoDTO;
import com.bantads.cliente.bantadscliente.data.AnaliseRepository;
import com.bantads.cliente.bantadscliente.model.Analise;
import com.bantads.cliente.bantadscliente.services.Producer.Analise.SenderAnalise;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerAnaliseVinculo {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SenderAnalise senderAnalise;

    @Autowired
    private AnaliseRepository analiseRepository;

    @RabbitListener(queues = "analise-gerente-vinculo")
    public void receive(@Payload String json) throws JsonMappingException, JsonProcessingException {
        try {
            AnaliseVinculoDTO analiseVinculoDTO = objectMapper.readValue(json, AnaliseVinculoDTO.class);
            Optional<Analise> analiseOp = analiseRepository.findById(analiseVinculoDTO.getId());
            Analise analise = analiseOp.get();
            analise.setIdExternoGerente(analiseVinculoDTO.getIdExternoGerente());
            analiseRepository.save(analise);
        } catch (Exception e) {
            System.out.println(e);
            AnaliseVinculoDTO analiseVinculoDTO = objectMapper.readValue(json, AnaliseVinculoDTO.class);
            senderAnalise.send(analiseVinculoDTO.getId());
        }
    }
}
