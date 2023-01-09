package com.bantads.conta.bantadsconta.services;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderTesteConfig {
	
	@Value("conta-inserir")
    private String queueInserirConta;
	
	@Bean
    public Queue queueInserirConta(){
        return new Queue(queueInserirConta, true);
    }
}
