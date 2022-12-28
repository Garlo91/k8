package com.banco.poder.clientes.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.poder.clientes.entity.Clientes;
import com.banco.poder.clientes.modelo.ClientesDto;
import com.banco.poder.clientes.modelo.TemplateResponse;
import com.banco.poder.clientes.service.ClientesServiceImpl;

@RestController
@RequestMapping("clientes/v1")
public class ClientesController {

	private static final Logger log = Logger.getLogger(ClientesController.class);
	@Autowired
	private ClientesServiceImpl clientesServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody ClientesDto clientesDto) {
		log.info(">>> clientes/v1 creando clientes, wuju dinero!!");

		Clientes clientes = clientesServiceImpl.guardar(clientesDto);

		TemplateResponse response = new TemplateResponse("El Cliente se ha creado exitosamente", "201", clientes);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Clientes consultarClientesaById(@PathVariable("id") String id) {
		log.info(">>> clientes/v1 consultarClientesaById ");

		return clientesServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Clientes> obtenerTodosLosClientes() {
		log.info(">>> clientes/v1 obtenerTodosLosClientes ");

		return clientesServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse modificarClientes(@PathVariable("id") String id, @RequestBody ClientesDto clientesDto) {
		log.info(">>> clientes/v1 modificarClientes ");

		Clientes clientes = clientesServiceImpl.modificar(id, clientesDto);
		TemplateResponse response = new TemplateResponse("El Cliente se ha actualizado exitosamente", "200", clientes);

		return response;

	}
}
