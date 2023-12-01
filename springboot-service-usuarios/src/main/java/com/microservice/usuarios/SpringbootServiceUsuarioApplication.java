package com.microservice.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.microservice.commons.users.entity"})
@SpringBootApplication
public class SpringbootServiceUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceUsuarioApplication.class, args);
	}

}
