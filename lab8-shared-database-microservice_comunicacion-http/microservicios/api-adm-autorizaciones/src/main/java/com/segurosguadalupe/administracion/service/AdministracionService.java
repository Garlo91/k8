package com.segurosguadalupe.administracion.service;

import java.util.List;

import com.segurosguadalupe.administracion.entity.Autorizaciones;
import com.segurosguadalupe.administracion.modelo.AutorizacionesResumenDto;
import com.segurosguadalupe.administracion.modelo.SegurosDto;

public interface AdministracionService {

	AutorizacionesResumenDto guardarAutorizaciones(SegurosDto datosSeguro);
	Autorizaciones obtenerAutorizacion(String id);
	List<Autorizaciones> obtenerAutorizaciones();
	AutorizacionesResumenDto modificaById(String id,Boolean confirmacion);
}
