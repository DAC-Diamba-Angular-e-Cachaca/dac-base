package com.bantads.orquestrador.bantadsorquestrador.services.Cliente;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderClienteConfig {
    @Value("autocadastro-cliente")
    private String queueCliente;

    @Bean
    public Queue queueCliente() {
        return new Queue(queueCliente, true);
    }
}
