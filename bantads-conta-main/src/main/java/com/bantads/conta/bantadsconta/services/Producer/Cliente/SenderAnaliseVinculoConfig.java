package com.bantads.conta.bantadsconta.services.Producer.Cliente;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderAnaliseVinculoConfig {
    @Value("analise-gerente-vinculo")
    private String queueAnaliseGerenteVinculo;

    @Bean
    public Queue queueAnaliseGerenteVinculo(){
        return new Queue(queueAnaliseGerenteVinculo);
    }
}
