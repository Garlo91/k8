package com.banco.poder.creditos.modelo;

public class ReferenciasDto {
	
	private String id;
	private String nombre;
	private String apellidos;
	private String tipoReferencia;
	private Integer aniosConocimiento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoReferencia() {
		return tipoReferencia;
	}

	public void setTipoReferencia(String tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}

	public Integer getAniosConocimiento() {
		return aniosConocimiento;
	}

	public void setAniosConocimiento(Integer aniosConocimiento) {
		this.aniosConocimiento = aniosConocimiento;
	}

}
