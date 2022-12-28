package com.banco.poder.creditos.modelo;

import java.util.List;

public class CreditosDto {

	private String idCredito;
	private String fecha;
	private String pais;
	private String canal;
	private SucursalDto sucursal;
	private String cliente;
	private String producto;
	private Double monto;
	private Integer plazo;
	private List<ReferenciasDto> referencias;

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public SucursalDto getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDto sucursal) {
		this.sucursal = sucursal;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public List<ReferenciasDto> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<ReferenciasDto> referencias) {
		this.referencias = referencias;
	}

}
