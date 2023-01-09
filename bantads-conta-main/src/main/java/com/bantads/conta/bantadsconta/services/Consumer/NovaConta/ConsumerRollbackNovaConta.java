package com.bantads.conta.bantadsconta.services.Consumer.NovaConta;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.data.CUD.ContaCRepository;
import com.bantads.conta.bantadsconta.data.R.ContaRRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;

@Component
public class ConsumerRollbackNovaConta {
    @Autowired
    private ContaCRepository contaCRepository;

    @Autowired
    private ContaRRepository contaRRepository;

    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @RabbitListener(queues = "nova-conta-rollback")
    public void receive(@Payload String json) {
        try {
            UUID saga = UUID.fromString(json);
            contaCRepository.deleteBySaga(saga);
            contaRRepository.deleteBySaga(saga);

            GerenteConta gerenteConta = gerenteContaRepository.findBySaga(saga);
            gerenteConta.setQuantidadeContas(gerenteConta.getQuantidadeContas() - 1);
        } catch (Exception e) {
            System.out.println(e);
        }     
    }
}
