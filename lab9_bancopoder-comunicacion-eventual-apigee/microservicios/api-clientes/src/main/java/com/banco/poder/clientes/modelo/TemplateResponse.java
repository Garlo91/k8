package com.banco.poder.clientes.modelo;

public class TemplateResponse {

	private String mensaje;
	private String codigo;
	private Object detalles;

	public TemplateResponse(String mensaje, String codigo, Object detalles) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.detalles = detalles;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Object getDetalles() {
		return detalles;
	}

	public void setDetalles(Object detalles) {
		this.detalles = detalles;
	}

}
