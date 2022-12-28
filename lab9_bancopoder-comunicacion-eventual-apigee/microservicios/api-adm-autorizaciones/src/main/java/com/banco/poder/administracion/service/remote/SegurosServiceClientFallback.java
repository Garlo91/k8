package com.banco.poder.administracion.service.remote;

import org.springframework.stereotype.Component;

import com.banco.poder.administracion.modelo.AutorizacionesResumenDto;
import com.banco.poder.administracion.modelo.ConfirmacionDto;
import com.banco.poder.administracion.modelo.ConfirmacionResumenDto;
@Component
public class SegurosServiceClientFallback implements SegurosServiceRemote {

	@Override
	public ConfirmacionResumenDto confirmacionesPoliza(ConfirmacionDto confirmaciones) {
		// TODO Auto-generated method stub
		return new ConfirmacionResumenDto();
	}
}