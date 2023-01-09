package com.bantads.conta.bantadsconta;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bantads.conta.bantadsconta.services.Producer.Cliente.SenderAnaliseVinculo;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao.SenderAutenticacao;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Autenticacao.SenderNovaSenha;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Cliente.SenderAnalise;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Cliente.SenderAprovacao;
import com.bantads.conta.bantadsconta.services.Producer.Rollback.Gerente.SenderGerente;

@EnableRabbit
@SpringBootApplication
public class BantadsContaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BantadsContaApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public SenderGerente senderG() {
		return new SenderGerente();
	}

	@Bean
	public SenderAutenticacao senderA() {
		return new SenderAutenticacao();
	}

	@Bean
	public SenderAnalise senderAn() {
		return new SenderAnalise();
	}

	@Bean
	public SenderAnaliseVinculo senderAv(){
		return new SenderAnaliseVinculo();
	}

	@Bean
	public SenderNovaSenha senderAs(){
		return new SenderNovaSenha();
	}

	@Bean
	public SenderAprovacao senderAp(){
		return new SenderAprovacao();
	}
}
