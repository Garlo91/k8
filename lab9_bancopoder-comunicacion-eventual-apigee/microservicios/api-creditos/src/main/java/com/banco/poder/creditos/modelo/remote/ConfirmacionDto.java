package com.banco.poder.creditos.modelo.remote;

import com.banco.poder.creditos.modelo.CreditosDto;

public class ConfirmacionDto {

	private Boolean autorizacion;
	private String idAutorizacion;
	private String datosValidacion;

	public Boolean getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(Boolean autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getIdAutorizacion() {
		return idAutorizacion;
	}

	public void setIdAutorizacion(String idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public String getDatosValidacion() {
		return datosValidacion;
	}

	public void setDatosValidacion(String datosValidacion) {
		this.datosValidacion = datosValidacion;
	}

}
