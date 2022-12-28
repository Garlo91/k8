package com.segurosguadalupe.service;

import java.util.List;

import com.segurosguadalupe.entity.Catalogos;
import com.segurosguadalupe.entity.Seguros;
import com.segurosguadalupe.modelo.ConfirmacionResumenDto;
import com.segurosguadalupe.modelo.PolizaDto;
import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.ConfirmacionDto;

public interface SegurosService {

	PolizaDto poliza(SegurosDto seguros);
	Seguros guardarSeguros(SegurosDto seguros);
	List<Catalogos> obtenerCatSeguros();
	Seguros obtenerSeguroById(String id);
	ConfirmacionResumenDto modificaSeguro(ConfirmacionDto confirmacion);
}
