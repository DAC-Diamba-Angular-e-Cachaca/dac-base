package com.bantads.orquestrador.bantadsorquestrador;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bantads.orquestrador.bantadsorquestrador.services.Autenticacao.SenderAutenticacao;
import com.bantads.orquestrador.bantadsorquestrador.services.Cliente.SenderCliente;
import com.bantads.orquestrador.bantadsorquestrador.services.Conta.SenderDeleteGerenteConta;
import com.bantads.orquestrador.bantadsorquestrador.services.Conta.SenderGerenteConta;
import com.bantads.orquestrador.bantadsorquestrador.services.Gerente.SenderDeleteGerente;
import com.bantads.orquestrador.bantadsorquestrador.services.Gerente.SenderGerente;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableRabbit
@SpringBootApplication
public class BantadsOrquestradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BantadsOrquestradorApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public SenderCliente senderC() {
		return new SenderCliente();
	}

	@Bean
	public SenderAutenticacao senderA() {
		return new SenderAutenticacao();
	}

	@Bean
	public SenderGerente senderG() {
		return new SenderGerente();
	}

	@Bean
	public SenderGerenteConta senderGC() {
		return new SenderGerenteConta();
	}

	@Bean
	public SenderDeleteGerente senderDg(){
		return new SenderDeleteGerente();
	}

	@Bean
	public SenderDeleteGerenteConta senderDgc(){
		return new SenderDeleteGerenteConta();
	}
}
