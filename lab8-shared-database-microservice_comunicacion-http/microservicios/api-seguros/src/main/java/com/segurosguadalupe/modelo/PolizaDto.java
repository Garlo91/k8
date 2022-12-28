package com.segurosguadalupe.modelo;

import com.segurosguadalupe.modelo.remote.AutorizacionesResumenDto;

public class PolizaDto {

	private String folio;
	private String mensaje;
	private SegurosDto seguros;
	private AutorizacionesResumenDto autorizaciones;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public SegurosDto getSeguros() {
		return seguros;
	}

	public void setSeguros(SegurosDto seguros) {
		this.seguros = seguros;
	}

	public AutorizacionesResumenDto getAutorizaciones() {
		return autorizaciones;
	}

	public void setAutorizaciones(AutorizacionesResumenDto autorizaciones) {
		this.autorizaciones = autorizaciones;
	}

}
