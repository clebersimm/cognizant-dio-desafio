package br.clebersimm.projetoteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Projeto teste")})
@SpringBootApplication
public class ProjetotesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetotesteApplication.class, args);
	}
}
