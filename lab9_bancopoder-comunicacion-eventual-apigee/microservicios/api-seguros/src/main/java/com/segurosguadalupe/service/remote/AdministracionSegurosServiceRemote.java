package com.segurosguadalupe.service.remote;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.AutorizacionesResumenDto;

@FeignClient(name = "ms-seguros-adm-event-svc", url = "http://ms-seguros-adm-event-svc:8080",fallback=AutorizacionesServiceClientFallback.class)
public interface AdministracionSegurosServiceRemote {

	@RequestMapping(method = POST, value = "administracion/v1/autorizaciones", produces = "application/json")
	AutorizacionesResumenDto solicitaAutorizacion(@RequestBody SegurosDto datosSeguro);

}
