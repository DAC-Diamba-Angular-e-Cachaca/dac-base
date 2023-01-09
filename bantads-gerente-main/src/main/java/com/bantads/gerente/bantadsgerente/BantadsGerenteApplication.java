package com.bantads.gerente.bantadsgerente;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao.SenderAutenticacao;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao.SenderDeleteUsuario;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.Autenticacao.SenderRollbackDeleteUsuario;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta.SenderGerenteConta;
import com.bantads.gerente.bantadsgerente.services.Producer.Rollback.GerenteConta.SenderRollbackDeleteGerenteConta;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableRabbit
@SpringBootApplication
public class BantadsGerenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BantadsGerenteApplication.class, args);
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
	public SenderAutenticacao senderA() {
		return new SenderAutenticacao();
	}

	@Bean 
	public SenderGerenteConta senderG() {
		return new SenderGerenteConta();
	}

	@Bean
	public SenderDeleteUsuario senderDu(){
		return new SenderDeleteUsuario();
	}

	@Bean
	public SenderRollbackDeleteUsuario senderRdu(){
		return new SenderRollbackDeleteUsuario();
	}

	@Bean
	public SenderRollbackDeleteGerenteConta senderRdg(){
		return new SenderRollbackDeleteGerenteConta();
	}
}
