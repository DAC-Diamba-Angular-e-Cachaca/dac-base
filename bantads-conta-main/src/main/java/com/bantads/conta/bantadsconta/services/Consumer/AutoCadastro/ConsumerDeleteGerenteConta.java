package com.bantads.conta.bantadsconta.services.Consumer.AutoCadastro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.conta.bantadsconta.data.CUD.ContaCRepository;
import com.bantads.conta.bantadsconta.data.R.ContaRRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.bantads.conta.bantadsconta.model.R.ContaR;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;

@Component
public class ConsumerDeleteGerenteConta {
    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @Autowired
    private ContaCRepository contaCRepository;

    @Autowired
    private ContaRRepository contaRRepository;

    @RabbitListener(queues = "delete-gerente-conta")
    public void receive(@Payload String json) {
        try {
            UUID idExternoGerente = UUID.fromString(json);
            GerenteConta gerenteConta = getGerenteConta(idExternoGerente);
            List<ContaC> contasC = getContasC(gerenteConta.getIdExternoGerente());
            List<ContaR> contasR = getContasR(gerenteConta.getIdExternoGerente());
            GerenteConta proximoGerenteConta = getProximoGerenteConta(idExternoGerente);
            changeGerenteContaC(proximoGerenteConta, contasC);
            changeGerenteContaR(proximoGerenteConta, contasR);
            updateProximoGerente(gerenteConta, proximoGerenteConta);

            gerenteConta.setAtivo(false);
            gerenteConta.setQuantidadeContas(0);
            gerenteContaRepository.save(gerenteConta);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private GerenteConta getGerenteConta(UUID idExternoGerente) {
        GerenteConta gerenteConta = new GerenteConta();
        gerenteConta = gerenteContaRepository.findByIdExternoGerente(idExternoGerente);
        return gerenteConta;
    }

    private List<ContaC> getContasC(UUID idExternoGerente) {
        List<ContaC> contasC = new ArrayList<ContaC>();
        contasC = contaCRepository.findByIdExternoGerente(idExternoGerente);
        return contasC;
    }

    private void changeGerenteContaC(GerenteConta gerenteConta, List<ContaC> contasC) {
        for (ContaC contaC : contasC) {
            contaC.setIdExternoGerente(gerenteConta.getIdExternoGerente());
            contaCRepository.save(contaC);
        }
    }

    private List<ContaR> getContasR(UUID idExternoGerente) {
        List<ContaR> contasR = new ArrayList<ContaR>();
        contasR = contaRRepository.findByIdExternoGerente(idExternoGerente).get();
        return contasR;
    }

    private void changeGerenteContaR(GerenteConta gerenteConta, List<ContaR> contasR) {
        for (ContaR contaR : contasR) {
            contaR.setIdExternoGerente(gerenteConta.getIdExternoGerente());
            contaRRepository.save(contaR);
        }
    }

    private GerenteConta getProximoGerenteConta(UUID id) {
        List<GerenteConta> gerenteContas = new ArrayList<GerenteConta>();
        gerenteContas = gerenteContaRepository.getGerenteContaMenosContas();
        GerenteConta proximoGerenteConta = new GerenteConta();
        for(GerenteConta gerenteConta: gerenteContas){
            if(!gerenteConta.getIdExternoGerente().equals(id)){
                proximoGerenteConta = gerenteConta;
                break;                
            }
        }
        return proximoGerenteConta;
    }

    private void updateProximoGerente(GerenteConta gerenteConta, GerenteConta proximoGerenteConta){
        proximoGerenteConta.setQuantidadeContas(proximoGerenteConta.getQuantidadeContas() + gerenteConta.getQuantidadeContas());
        proximoGerenteConta.setSaldoPositivo(proximoGerenteConta.getSaldoPositivo().add(gerenteConta.getSaldoPositivo()));
        proximoGerenteConta.setSaldoNegativo(proximoGerenteConta.getSaldoNegativo().add(gerenteConta.getSaldoNegativo()));
        gerenteContaRepository.save(proximoGerenteConta);
    }
}
