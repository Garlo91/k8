package com.segurosguadalupe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class SegurosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurosApplication.class, args);
	}

}
