package com.banco.poder.creditos.modelo;

public class AutorizacionDto {

	private String idAutorizacion;
	private String datosValidacion;
	private boolean estatus;
	private String fechaApertura;
	private String fechaConfirmacion;

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

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getFechaConfirmacion() {
		return fechaConfirmacion;
	}

	public void setFechaConfirmacion(String fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

}
