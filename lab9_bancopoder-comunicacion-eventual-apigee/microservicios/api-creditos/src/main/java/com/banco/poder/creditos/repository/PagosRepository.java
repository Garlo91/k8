package com.banco.poder.creditos.repository;

import java.util.List;

import com.banco.poder.creditos.modelo.PagosDto;

public interface PagosRepository {

	List<PagosDto> consultarTodo(String id);
	
	PagosDto consultarById(String id);

	PagosDto persistir(PagosDto pagosDto,String idCredito);
	
	void eliminar(String idCredito);
}
