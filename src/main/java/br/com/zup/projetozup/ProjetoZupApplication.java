package br.com.zup.projetozup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ProjetoZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoZupApplication.class, args);
	}

}
