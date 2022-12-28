package com.segurosguadalupe.administracion.service.remote;

import org.springframework.stereotype.Component;

import com.segurosguadalupe.administracion.modelo.AutorizacionesResumenDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionResumenDto;
@Component
public class SegurosServiceClientFallback implements SegurosServiceRemote {

	@Override
	public ConfirmacionResumenDto confirmacionesPoliza(ConfirmacionDto confirmaciones) {
		// TODO Auto-generated method stub
		return new ConfirmacionResumenDto();
	}
}