package com.segurosguadalupe.administracion.modelo;

public class AutorizacionesResumenDto {

	private String folio;
	private String mensaje;
	
	public AutorizacionesResumenDto() {
		
	}

	public AutorizacionesResumenDto(String folio, String mensaje) {
		super();
		this.folio = folio;
		this.mensaje = mensaje;
	}

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

}
