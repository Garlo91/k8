package com.banco.poder.empleados.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.banco.poder.empleados.modelo.EmpleadosDto;

@Entity
@Table(name = "empleados")
public class Empleados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@NotBlank
	private String nombre;
	@NotBlank
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	@NotBlank
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	private Integer edad;
	@NotBlank
	private String curp;
	@NotBlank
	private String rfc;
	@NotBlank
	private String domicilio;
	@NotBlank
	private String imagen;
	@NotBlank
	private String puesto;
	private Boolean estatus;
	@Column(name = "numero_empleado")
	@NotBlank
	private String numeroEmpleado;

	public static Empleados from(EmpleadosDto segurosDto) {
		Empleados empleados = new Empleados();
		empleados.setApellidoMaterno(segurosDto.getApellidoMaterno());
		empleados.setApellidoPaterno(segurosDto.getApellidoPaterno());
		empleados.setCurp(segurosDto.getCurp());
		empleados.setDomicilio(segurosDto.getDomicilio());
		empleados.setEdad(segurosDto.getEdad());
		empleados.setImagen(segurosDto.getImagen());
		empleados.setNombre(segurosDto.getNombre());
		empleados.setNumeroEmpleado(segurosDto.getNumeroEmpleado());
		empleados.setPuesto(segurosDto.getPuesto());
		empleados.setRfc(segurosDto.getRfc());
		empleados.setEstatus(segurosDto.getStatus());

		return empleados;
	}

	public EmpleadosDto to() {

		EmpleadosDto empleados = new EmpleadosDto();
		empleados.setId(getId());
		empleados.setNombre(getNombre());
		empleados.setApellidoPaterno(getApellidoPaterno());
		empleados.setApellidoMaterno(getApellidoMaterno());
		empleados.setCurp(getCurp());
		empleados.setDomicilio(getDomicilio());
		empleados.setEdad(getEdad());
		empleados.setImagen(getImagen());
		empleados.setNumeroEmpleado(getNumeroEmpleado());
		empleados.setPuesto(getPuesto());
		empleados.setRfc(getRfc());
		empleados.setStatus(getEstatus());

		return empleados;
	}

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

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

}
