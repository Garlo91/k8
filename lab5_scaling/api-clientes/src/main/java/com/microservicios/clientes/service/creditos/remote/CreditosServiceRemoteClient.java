package com.microservicios.clientes.service.creditos.remote;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservicios.clientes.service.creditos.modelo.Credito;
import com.microservicios.clientes.service.creditos.modelo.ResumenCredito;

@FeignClient(name = "servicio-creditos", url = "http://servicio-creditos:8081") 
public interface CreditosServiceRemoteClient {
	@RequestMapping(method = POST, value = "api/v1/creditos")
	ResumenCredito guardarCredito(@RequestBody Credito credito);
}
