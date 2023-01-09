package com.bantads.cliente.bantadscliente.services.Producer.Aprovacao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderGerarSenhaConfig {
    @Value("gerar-senha-cliente")
    private String queueGerarSenhaCliente;

    @Bean
    public Queue queueGerarSenhaCliente(){
        return new Queue(queueGerarSenhaCliente);
    }
}
