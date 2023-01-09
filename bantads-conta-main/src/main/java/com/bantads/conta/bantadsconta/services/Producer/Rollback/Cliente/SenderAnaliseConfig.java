package com.bantads.conta.bantadsconta.services.Producer.Rollback.Cliente;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderAnaliseConfig {
    @Value("analise-gerente")
    private String queueAnaliseGerente;

    @Bean
    public Queue queueAnaliseGerente() {
        return new Queue(queueAnaliseGerente);
    }
}
