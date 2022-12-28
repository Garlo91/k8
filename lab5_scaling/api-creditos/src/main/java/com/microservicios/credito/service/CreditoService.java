package com.microservicios.credito.service;

import com.microservicios.credito.modelo.Credito;
import com.microservicios.credito.modelo.ResumenCredito;

public interface CreditoService {

	public ResumenCredito generarCredito(Credito credito);
}
