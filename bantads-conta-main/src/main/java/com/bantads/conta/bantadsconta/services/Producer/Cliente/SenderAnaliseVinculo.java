package com.bantads.conta.bantadsconta.services.Producer.Cliente;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.AnaliseVinculoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SenderAnaliseVinculo {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueAnaliseGerenteVinculo;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(AnaliseVinculoDTO analiseVinculoDTO) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(analiseVinculoDTO);
        this.template.convertAndSend(this.queueAnaliseGerenteVinculo.getName(), json);
    }
}
