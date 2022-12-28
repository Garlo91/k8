package com.banco.poder.administracion.modelo;

public class SegurosDto {

	private String id;
	private Double plazo;
	private Double precioPoliza;
	private Integer tipoCobertura;
	private String vencimiento;
	private Double sumaAsegurada;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String fechaNacimiento;
	private String sexo;
	private Double ingresosAnuales;
	private String direccion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPlazo() {
		return plazo;
	}

	public void setPlazo(Double plazo) {
		this.plazo = plazo;
	}

	public Double getPrecioPoliza() {
		return precioPoliza;
	}

	public void setPrecioPoliza(Double precioPoliza) {
		this.precioPoliza = precioPoliza;
	}

	public Integer getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(Integer tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getIngresosAnuales() {
		return ingresosAnuales;
	}

	public void setIngresosAnuales(Double ingresosAnuales) {
		this.ingresosAnuales = ingresosAnuales;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
