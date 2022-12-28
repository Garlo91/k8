package com.banco.poder.creditos.repository;

import java.util.List;

import com.banco.poder.creditos.modelo.ReferenciasDto;

public interface ReferenciasRepository {

	ReferenciasDto persistir(String idCredito, ReferenciasDto referenciasDto);

	ReferenciasDto buscarById(String id, String idCredito);

	List<ReferenciasDto> buscarTodo(String id);

	void eliminar(String idCredito);
}
