package com.banco.poder.clientes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.banco.poder.clientes.modelo.ClientesDto;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

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
	@Column(name = "apellido_paterno")
	@NotBlank
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	@NotBlank
	private String apellidoMaterno;
	private Integer edad;
	@NotBlank
	private String rfc;
	@NotBlank
	private String email;
	@NotBlank
	private String direccion;
	@Column(name = "codigo_postal")
	private String codigoPostal;
	private String referencias;
	@NotBlank
	private String genero;

	public static Clientes from(ClientesDto clientesDto) {
		Clientes clientes = new Clientes();
		clientes.setApellidoMaterno(clientesDto.getApellidoMaterno());
		clientes.setApellidoPaterno(clientesDto.getApellidoPaterno());
		clientes.setCodigoPostal(clientesDto.getCodigoPostal());
		clientes.setDireccion(clientesDto.getDireccion());
		clientes.setEdad(clientesDto.getEdad());
		clientes.setEmail(clientesDto.getEmail());
		clientes.setGenero(clientesDto.getGenero());
		clientes.setNombre(clientesDto.getNombre());
		clientes.setReferencias(clientesDto.getReferencias());
		clientes.setRfc(clientesDto.getRfc());

		return clientes;
	}

	public ClientesDto to() {

		ClientesDto clientes = new ClientesDto();
		clientes.setId(getId());
		clientes.setNombre(getNombre());
		clientes.setApellidoPaterno(getApellidoPaterno());
		clientes.setApellidoMaterno(getApellidoMaterno());
		clientes.setCodigoPostal(getCodigoPostal());
		clientes.setDireccion(getDireccion());
		clientes.setEdad(getEdad());
		clientes.setEmail(getEmail());
		clientes.setGenero(getGenero());
		clientes.setReferencias(getReferencias());
		clientes.setRfc(getRfc());

		return clientes;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
