package com.banco.poder.clientes.modelo.remote;

public class ConfirmacionDto {

	private Boolean autorizacion;
	private String idSeguro;

	public Boolean getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(Boolean autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(String idSeguro) {
		this.idSeguro = idSeguro;
	}

}
