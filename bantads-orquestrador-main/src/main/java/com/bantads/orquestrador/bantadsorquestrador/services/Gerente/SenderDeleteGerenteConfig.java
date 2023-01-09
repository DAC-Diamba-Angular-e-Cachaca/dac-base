package com.bantads.orquestrador.bantadsorquestrador.services.Gerente;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderDeleteGerenteConfig {
    @Value("delete-gerente")
    private String queueDeleteGerente;

    @Bean
    public Queue queueDeleteGerente() {
        return new Queue(queueDeleteGerente, true);
    }
}
