package com.bantads.conta.bantadsconta.services;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderContaConfig {
	
	@Value("conta-inserir-read")
    private String queueInserirContaRead;

    @Bean
    public Queue queueInserirContaRead(){
        return new Queue(queueInserirContaRead, true);
    }
}
