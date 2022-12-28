package com.banco.poder.creditos.service;

import java.util.List;

import com.banco.poder.creditos.modelo.AprobacionDto;

public interface AprobacionesService {

	void guardar(AprobacionDto aprobacionDto);

	AprobacionDto obtenerById(String idCredito);

	List<AprobacionDto> obtenerTodo();
	
	
	
}
