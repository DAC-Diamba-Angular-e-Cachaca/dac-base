package com.bantads.autenticacao.bantadsautenticacao.services.Producer.Rollback.Cliente;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderClienteConfig {
    @Value("autocadastro-cliente-rollback")
    private String queueRollbackAutocadastroAutenticacao;

    @Bean
    public Queue queueRollbackAutocadastroAutenticacao() {
        return new Queue(queueRollbackAutocadastroAutenticacao);
    }
}
