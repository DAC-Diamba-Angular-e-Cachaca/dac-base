package com.bantads.orquestrador.bantadsorquestrador.services.Gerente;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderGerenteConfig {
    @Value("autocadastro-gerente")
    private String queueGerente;

    @Bean
    public Queue queueGerente() {
        return new Queue(queueGerente, true);
    }
}
