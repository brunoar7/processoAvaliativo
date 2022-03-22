package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EProcessoAvaliativoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EProcessoAvaliativoApiApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
