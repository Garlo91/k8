package com.segurosguadalupe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.segurosguadalupe.modelo.SegurosDto;

@Entity
@Table(name = "seguros")
public class Seguros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	private Double plazo;
	@Column(name = "precio_poliza")
	private Double precioPoliza;
	@Column(name = "tipo_cobertura")
	private Integer tipoCobertura;
	@NotBlank
	private String vencimiento;
	@Column(name = "suma_asegurada")
	private Double sumaAsegurada;
	@NotBlank
	private String nombre;
	@Column(name = "apellido_paterno")
	@NotBlank
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	@NotBlank
	private String apellidoMaterno;
	@Column(name = "fecha_nacimiento")
	@NotBlank
	private String fechaNacimiento;
	@NotBlank
	private String sexo;
	@Column(name = "ingresos_anuales")
	private Double ingresosAnuales;
	@NotBlank
	private String direccion;
	private Boolean autorizacion;

	public static Seguros from(SegurosDto segurosDto) {
		Seguros seguros = new Seguros();
		seguros.setNombre(segurosDto.getNombre());
		seguros.setApellidoPaterno(segurosDto.getApellidoPaterno());
		seguros.setApellidoMaterno(segurosDto.getApellidoMaterno());
		seguros.setFechaNacimiento(segurosDto.getFechaNacimiento());
		seguros.setSexo(segurosDto.getSexo());
		seguros.setDireccion(segurosDto.getDireccion());
		seguros.setIngresosAnuales(segurosDto.getIngresosAnuales());
		seguros.setPlazo(segurosDto.getPlazo());
		seguros.setPrecioPoliza(segurosDto.getPrecioPoliza());
		seguros.setTipoCobertura(segurosDto.getTipoCobertura());
		seguros.setSumaAsegurada(segurosDto.getSumaAsegurada());
		seguros.setVencimiento(segurosDto.getVencimiento());
		seguros.setAutorizacion(segurosDto.getAutorizacion());

		return seguros;
	}

	public SegurosDto to() {

		SegurosDto seguros = new SegurosDto();
		seguros.setId(getId());
		seguros.setNombre(getNombre());
		seguros.setApellidoPaterno(getApellidoPaterno());
		seguros.setApellidoMaterno(getApellidoMaterno());
		seguros.setFechaNacimiento(getFechaNacimiento());
		seguros.setSexo(getSexo());
		seguros.setDireccion(getDireccion());
		seguros.setIngresosAnuales(getIngresosAnuales());
		seguros.setPlazo(getPlazo());
		seguros.setPrecioPoliza(getPrecioPoliza());
		seguros.setTipoCobertura(getTipoCobertura());
		seguros.setSumaAsegurada(getSumaAsegurada());
		seguros.setVencimiento(getVencimiento());
		seguros.setAutorizacion(getAutorizacion());

		return seguros;
	}

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

	public Boolean getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(Boolean autorizacion) {
		this.autorizacion = autorizacion;
	}

}
