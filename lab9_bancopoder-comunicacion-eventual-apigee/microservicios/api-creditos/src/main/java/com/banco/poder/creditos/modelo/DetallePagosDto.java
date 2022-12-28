package com.banco.poder.creditos.modelo;

import java.util.List;

public class DetallePagosDto {

	private String idCredito;
	private Double capital;
	private String intereses;
	private List<PagosDto> pagos;

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public String getIntereses() {
		return intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public List<PagosDto> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagosDto> pagos) {
		this.pagos = pagos;
	}

}
