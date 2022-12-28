package com.banco.poder.administracion.service;

import java.util.List;

import com.banco.poder.administracion.entity.Autorizaciones;
import com.banco.poder.administracion.modelo.AutorizacionesResumenDto;

public interface AdministracionService {

	AutorizacionesResumenDto guardarAutorizaciones(Autorizaciones autorizaciones);
	Autorizaciones obtenerAutorizacion(String id);
	List<Autorizaciones> obtenerAutorizaciones();
	AutorizacionesResumenDto modificaById(String id,Boolean confirmacion);
}
