package com.bantads.orquestrador.bantadsorquestrador.services.Conta;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderGerenteContaConfig {
    @Value("autocadastro-gerente-conta")
    private String queueGerenteConta;

    @Bean
    public Queue queueGerenteConta(){
        return new Queue(queueGerenteConta, true);
    }
}
