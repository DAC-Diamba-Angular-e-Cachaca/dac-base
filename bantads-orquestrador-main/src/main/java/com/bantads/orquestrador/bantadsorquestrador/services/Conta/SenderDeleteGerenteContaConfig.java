package com.bantads.orquestrador.bantadsorquestrador.services.Conta;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderDeleteGerenteContaConfig {
    @Value("delete-gerente-conta")
    private String queueDeleteGerenteConta;

    @Bean
    public Queue queueDeleteGerenteConta() {
        return new Queue(queueDeleteGerenteConta, true);
    }
}
