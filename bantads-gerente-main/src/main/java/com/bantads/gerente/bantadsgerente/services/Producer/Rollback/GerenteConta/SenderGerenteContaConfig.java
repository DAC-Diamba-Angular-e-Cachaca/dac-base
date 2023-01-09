package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderGerenteContaConfig {
    @Value("autocadastro-gerente-conta-rollback")
    private String queueRollbackAutocadastroGerenteConta;

    @Bean
    public Queue queueRollbackAutocadastroGerenteConta() {
        return new Queue(queueRollbackAutocadastroGerenteConta);
    }
}
