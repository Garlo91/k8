package com.microservicios.credito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages="com.microservicios.credito")
public class CreditoServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CreditoServiceApplication.class, args);
  }

}
