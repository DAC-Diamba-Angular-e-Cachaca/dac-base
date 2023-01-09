package com.bantads.cliente.bantadscliente.services.Producer.Analise;

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
