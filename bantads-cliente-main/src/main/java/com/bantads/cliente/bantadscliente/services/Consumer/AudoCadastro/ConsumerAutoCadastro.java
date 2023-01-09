package com.bantads.cliente.bantadscliente.services.Consumer.AudoCadastro;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.data.ClienteRepository;
import com.bantads.cliente.bantadscliente.mapper.AnaliseMapper;
import com.bantads.cliente.bantadscliente.model.Cliente;
import com.bantads.cliente.bantadscliente.services.Producer.Analise.SenderAnalise;
import com.bantads.cliente.bantadscliente.services.Producer.Rollback.SenderAutenticacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerAutoCadastro {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SenderAnalise senderAnalise;

    @Autowired
    private SenderAutenticacao senderAutenticacao;

    @RabbitListener(queues = "autocadastro-cliente")
    public void receive(@Payload String json) throws JsonMappingException, JsonProcessingException {
        try {
            Cliente cliente = objectMapper.readValue(json, Cliente.class);
            cliente.setAnalise(AnaliseMapper.novaAnalise(cliente.getSaga()));
            cliente.getEndereco().setId(UUID.randomUUID());
            clienteRepository.save(cliente);
            senderAnalise.send(cliente.getAnalise().getId());
        } catch (Exception e) {
            System.out.println(e);
            Cliente cliente = objectMapper.readValue(json, Cliente.class);
            senderAutenticacao.send(cliente.getSaga());
        }
    }
}
