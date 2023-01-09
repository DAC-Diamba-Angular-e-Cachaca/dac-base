package com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderDeleteUsuarioConfig {
    @Value("delete-usuario")
    private String queueDeleteUsuario;

    @Bean
    public Queue queueDeleteUsuario(){
        return new Queue(queueDeleteUsuario);
    }
}
