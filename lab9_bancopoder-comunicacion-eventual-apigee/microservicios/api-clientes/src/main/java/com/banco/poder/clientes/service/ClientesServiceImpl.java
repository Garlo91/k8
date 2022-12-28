package com.banco.poder.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banco.poder.clientes.entity.Clientes;
import com.banco.poder.clientes.modelo.ClientesDto;
import com.banco.poder.clientes.repository.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {

	private ClientesRepository clientesRepository;

	public ClientesServiceImpl(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}

	@Override
	public Clientes obtenerById(String id) {
		return clientesRepository.findById(id)
				.orElseThrow(() -> ClientesNoEncontradoException.from("No se encontro el cliente", id));
	}

	@Override
	public Clientes guardar(ClientesDto clientesDto) {
		Clientes clientes = Clientes.from(clientesDto);
		return clientesRepository.save(clientes);
	}

	@Override
	public Clientes modificar(String id, ClientesDto clientesDto) {
		Clientes clientes = clientesRepository.findById(id)
				.orElseThrow(() -> ClientesNoEncontradoException.from("No se encontro el cliente", id));

		clientes = clientes.from(clientesDto);

		clientes = clientesRepository.save(clientes);

		return clientes;
	}

	@Override
	public List<Clientes> obtenerTodo() {

		return clientesRepository.findAll();
	}

	@Override
	public void remover(String id) {
		clientesRepository.findById(id)
				.orElseThrow(() -> ClientesNoEncontradoException.from("No se encontro el cliente", id));

		clientesRepository.delete(id);
	}

}