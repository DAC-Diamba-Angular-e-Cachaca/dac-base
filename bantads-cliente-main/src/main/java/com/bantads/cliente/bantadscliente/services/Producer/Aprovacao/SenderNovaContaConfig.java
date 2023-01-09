package com.bantads.cliente.bantadscliente.services.Producer.Aprovacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderNovaContaConfig {
    @Value("nova-conta")
    private String queueNovaConta;

    @Bean
    public Queue queueNovaConta(){
        return new Queue(queueNovaConta);
    }
}
