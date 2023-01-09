package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderRollbackDeleteUsuarioConfig {
    @Value("delete-usuario-rollback")
    private String queueDeleteUsuarioRollback;

    @Bean
    public Queue queueDeleteUsuarioRollback(){
        return new Queue(queueDeleteUsuarioRollback);
    }
}
