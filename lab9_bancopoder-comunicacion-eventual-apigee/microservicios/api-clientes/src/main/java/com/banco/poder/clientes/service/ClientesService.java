package com.banco.poder.clientes.service;

import java.util.List;

import com.banco.poder.clientes.entity.Clientes;
import com.banco.poder.clientes.modelo.ClientesDto;

public interface ClientesService {

	Clientes obtenerById(String id);

	Clientes guardar(ClientesDto clientesDto);

	Clientes modificar(String id, ClientesDto clientesDto);

	List<Clientes> obtenerTodo();
	
	void remover(String id);
}
