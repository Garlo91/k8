package com.banco.poder.creditos.repository;

import java.util.List;

import com.banco.poder.creditos.modelo.AprobacionDto;

public interface AprobacionesRepository {

	void persistir(AprobacionDto aprobacionDto);

	List<AprobacionDto> obtenerTodo();

	AprobacionDto obtenerById(String idCredito);
	
	void eliminar(String idCredito);
}
