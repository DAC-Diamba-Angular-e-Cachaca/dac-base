package com.bantads.conta.bantadsconta.services;

import java.math.BigDecimal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.ContaDTO;
import com.bantads.conta.bantadsconta.DTOs.GerenteContaDTO;
import com.bantads.conta.bantadsconta.data.CUD.ContaCRepository;
import com.bantads.conta.bantadsconta.data.R.ContaRRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.bantads.conta.bantadsconta.model.R.ContaR;
import com.bantads.conta.bantadsconta.services.SenderConta;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerConta {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @Autowired
    private ContaRRepository contaRepositoryR;

    @Autowired
    private ContaCRepository contaRepositoryCUD;

    @Autowired
    private SenderConta senderCliente;

    @RabbitListener(queues = "conta-inserir")
    public void receive(@Payload String json) {
        try {
            ContaDTO contaDTO = objectMapper.readValue(json, ContaDTO.class);

            ContaC conta = new ContaC(contaDTO);
            conta.setNumero(contaRepositoryCUD.maxNumero() + 1);
            contaRepositoryCUD.save(conta);
            senderCliente.sendInserirRead(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "conta-inserir-read")
    public void receiveRead(@Payload String json) {
        try {
            ContaR conta = objectMapper.readValue(json, ContaR.class);
            contaRepositoryR.save(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

