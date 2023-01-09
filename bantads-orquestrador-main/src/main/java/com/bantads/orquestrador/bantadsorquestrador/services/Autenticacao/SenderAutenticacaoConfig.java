package com.bantads.orquestrador.bantadsorquestrador.services.Autenticacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderAutenticacaoConfig {
    @Value("autocadastro-autenticacao")
    private String queueAutenticacao;

    @Bean
    public Queue queueAutenticacao(){
        return new Queue(queueAutenticacao, true);
    }
}
