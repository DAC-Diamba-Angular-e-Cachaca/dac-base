package com.bantads.conta.bantadsconta.services.Consumer.NovaConta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.DTOs.NovaContaDTO;
import com.bantads.conta.bantadsconta.data.CUD.ContaCRepository;
import com.bantads.conta.bantadsconta.data.R.ContaRRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.bantads.conta.bantadsconta.model.R.ContaR;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao.SenderNovaSenha;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Cliente.SenderAprovacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerNovaConta {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ContaCRepository contaCRepository;

    @Autowired
    private ContaRRepository contaRRepository;

    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @Autowired
    private SenderAprovacao senderAprovacao;

    @Autowired
    private SenderNovaSenha senderNovaSenha;

    @RabbitListener(queues = "nova-conta")
    public void receive(@Payload String json) throws JsonMappingException, JsonProcessingException {
        try {
            NovaContaDTO novaContaDTO = objectMapper.readValue(json, NovaContaDTO.class);
            ContaC contaC = novaContaC(novaContaDTO);
            ContaR contaR = mapper.map(contaC, ContaR.class);
            contaCRepository.save(contaC);
            contaRRepository.save(contaR);

            GerenteConta gerenteConta = gerenteContaRepository
                    .findByIdExternoGerente(novaContaDTO.getIdExternoGerente());
            gerenteConta.setSaga(novaContaDTO.getSaga());
            gerenteConta.setQuantidadeContas(gerenteConta.getQuantidadeContas() + 1);
            gerenteContaRepository.save(gerenteConta);
        } catch (Exception e) {
            System.out.println(e);
            NovaContaDTO novaContaDTO = objectMapper.readValue(json, NovaContaDTO.class);
            senderNovaSenha.send(novaContaDTO.getSaga());
            senderAprovacao.send(novaContaDTO.getSaga());
        }
    }

    private ContaC novaContaC(NovaContaDTO novaContaDTO) {
        ContaC conta = new ContaC();
        conta.setId(UUID.randomUUID());
        conta.setIdExternoCliente(novaContaDTO.getIdExternoCliente());
        conta.setIdExternoGerente(novaContaDTO.getIdExternoGerente());
        conta.setSaldo(new BigDecimal(0.0));
        conta.setLimite(getLimite(novaContaDTO.getSalario()));
        conta.setDataCriacao((Date) Calendar.getInstance().getTime());
        conta.setNumero(contaCRepository.maxNumero() + 1);
        conta.setSaga(novaContaDTO.getSaga());
        return conta;
    }

    private BigDecimal getLimite(BigDecimal salario) {
        BigDecimal limite = new BigDecimal(0.0);
        BigDecimal divisor = new BigDecimal(2);
        if (salario.compareTo(new BigDecimal(2000.00)) >= 0)
            limite = salario.divide(divisor, 2, RoundingMode.FLOOR);
        return limite;
    }
}
