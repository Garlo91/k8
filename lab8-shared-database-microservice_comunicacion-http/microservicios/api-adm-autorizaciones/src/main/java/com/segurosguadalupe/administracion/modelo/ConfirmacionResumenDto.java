package com.segurosguadalupe.administracion.modelo;

public class ConfirmacionResumenDto {

	private String folio;
	private String mensaje;
	
	public ConfirmacionResumenDto() {
		
	}

	public ConfirmacionResumenDto(String folio, String mensaje) {
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
