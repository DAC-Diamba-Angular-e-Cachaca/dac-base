package com.bantads.conta.bantadsconta.services.Consumer.AutoCadastro;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.GerenteContaDTO;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao.SenderAutenticacao;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Gerente.SenderGerente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerAutoCadastro {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @Autowired
    private SenderGerente senderGerente;

    @Autowired
    private SenderAutenticacao senderAutenticacao;

    @RabbitListener(queues = "autocadastro-gerente-conta")
    public void receive(@Payload String json) throws JsonMappingException, JsonProcessingException {
        try {
            GerenteContaDTO gerenteContaDTO = objectMapper.readValue(json, GerenteContaDTO.class);
            GerenteConta gerenteConta = new GerenteConta(
                    UUID.randomUUID(),
                    gerenteContaDTO.getId(),
                    0,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    true,
                    gerenteContaDTO.getSaga());
            gerenteContaRepository.save(gerenteConta);
        } catch (Exception e) {
            System.out.println(e);
            GerenteContaDTO gerenteContaDTO = objectMapper.readValue(json, GerenteContaDTO.class);
            senderGerente.send(gerenteContaDTO.getSaga());
            senderAutenticacao.send(gerenteContaDTO.getSaga());
        }
    }
}
