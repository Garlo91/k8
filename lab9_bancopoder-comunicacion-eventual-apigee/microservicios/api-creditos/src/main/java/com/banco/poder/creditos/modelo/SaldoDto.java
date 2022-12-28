package com.banco.poder.creditos.modelo;

public class SaldoDto {

	private String idCredito;
	private Double monto;
	private Double montoLiquidacion;

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getMontoLiquidacion() {
		return montoLiquidacion;
	}

	public void setMontoLiquidacion(Double montoLiquidacion) {
		this.montoLiquidacion = montoLiquidacion;
	}

}
