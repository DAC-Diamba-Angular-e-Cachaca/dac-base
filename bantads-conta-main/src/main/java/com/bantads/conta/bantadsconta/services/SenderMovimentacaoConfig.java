package com.bantads.conta.bantadsconta.services;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderMovimentacaoConfig {
	@Value("movimentacao-inserir")
    private String queueInserirMovimentacaoRead;
	
	@Bean
    public Queue queueInserirMovimentacaoRead(){
        return new Queue(queueInserirMovimentacaoRead, true);
    }
}
