package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderRollbackDeleteGerenteContaConfig {
    @Value("delete-gerente-conta-rollback")
    private String queueRollbackDeleteGerenteConta;

    @Bean
    public Queue queueRollbackDeleteGerenteConta(){
        return new Queue(queueRollbackDeleteGerenteConta);
    }
}
