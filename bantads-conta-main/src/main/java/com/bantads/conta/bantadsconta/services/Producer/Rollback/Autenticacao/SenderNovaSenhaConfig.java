package com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderNovaSenhaConfig {
    @Value("nova-senha-rollback")
    private String queueRollbackNovaSenha;

    @Bean
    public Queue queueRollbackNovaSenha() {
        return new Queue(queueRollbackNovaSenha);
    }
}
