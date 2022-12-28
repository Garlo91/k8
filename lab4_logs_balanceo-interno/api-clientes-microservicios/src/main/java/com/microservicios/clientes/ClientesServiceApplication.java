package com.microservicios.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


/**
 * <b>ClientesServiceApplication.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 */
@SpringBootApplication
@EnableFeignClients
public class ClientesServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientesServiceApplication.class, args);
  }
  
  

}
