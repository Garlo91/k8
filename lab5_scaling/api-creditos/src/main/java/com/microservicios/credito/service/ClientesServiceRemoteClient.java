package com.microservicios.credito.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservicios.credito.modelo.ClienteBean;

@FeignClient(name = "servicio-cliente", url = "http://servicio-cliente:8081")
public interface ClientesServiceRemoteClient {
	@RequestMapping(method = RequestMethod.GET, value = "api/v1/clientes")
	ClienteBean buscarCliente(@PathVariable("id") String folioCliente);
}
