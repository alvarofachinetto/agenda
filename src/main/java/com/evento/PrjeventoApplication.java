package com.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = {"com.evento.model"})
@ComponentScan(basePackages = {"com.*"})

public class PrjeventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjeventoApplication.class, args);
	}

}
