package com.segurosguadalupe.administracion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "autorizaciones")
public class Autorizaciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id_autorizacion", updatable = false)
	private String idAutorizacion;
	@Column(name = "datos_poliza")
	@NotBlank
	private String datosPoliza;
	private boolean estatus;
	@Column(name = "fecha_apertura")
	private String fechaApertura;
	@Column(name = "fecha_confirmacion")
	private String fechaConfirmacion;

	public String getIdAutorizacion() {
		return idAutorizacion;
	}

	public void setIdAutorizacion(String idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public String getDatosPoliza() {
		return datosPoliza;
	}

	public void setDatosPoliza(String datosPoliza) {
		this.datosPoliza = datosPoliza;
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
