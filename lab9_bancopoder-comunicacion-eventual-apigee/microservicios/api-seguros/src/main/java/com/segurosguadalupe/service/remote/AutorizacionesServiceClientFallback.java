package com.segurosguadalupe.service.remote;

import org.springframework.stereotype.Component;

import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.AutorizacionesResumenDto;
@Component
public class AutorizacionesServiceClientFallback implements AdministracionSegurosServiceRemote {

	@Override
	public AutorizacionesResumenDto solicitaAutorizacion(SegurosDto datosSeguro) {
		// TODO Auto-generated method stub
		return new AutorizacionesResumenDto();
	}

}