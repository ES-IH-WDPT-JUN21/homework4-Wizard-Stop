package com.ironhack.salesrep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SalesrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesrepApplication.class, args);
	}

}
