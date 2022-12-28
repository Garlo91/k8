package com.banco.poder.creditos.repository;

import java.util.List;

import com.banco.poder.creditos.modelo.CreditosDto;

public interface CreditosRepository {
	CreditosDto buscarById(String id);

	List<CreditosDto> buscarByIdTodo(String id);

	CreditosDto actualizar(String id, CreditosDto creditosDto);

	CreditosDto persistir(CreditosDto creditosDto);

	void eliminar(String id);
}
