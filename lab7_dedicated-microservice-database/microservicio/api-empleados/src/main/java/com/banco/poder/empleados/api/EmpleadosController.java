package com.banco.poder.empleados.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.poder.empleados.entity.Empleados;
import com.banco.poder.empleados.modelo.EmpleadosDto;
import com.banco.poder.empleados.modelo.TemplateResponse;
import com.banco.poder.empleados.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("empleados/v1")
public class EmpleadosController {

	private static final Logger log = Logger.getLogger(EmpleadosController.class);
	@Autowired
	private EmpleadosServiceImpl empleadosServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody EmpleadosDto empleado) {
		log.info(">>> empleados /v1 creando empleado");

		Empleados empleados = empleadosServiceImpl.guardar(empleado);

		TemplateResponse response = new TemplateResponse("El empleado se ha creado exitosamente", "201", empleados);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Empleados obtenerEmpleadoById(@PathVariable("id") String id) {
		log.info(">>> empleados/v1 obtenerEmpleadoById ");
		return empleadosServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Empleados> obtenerTodosLosEmpleados() {
		log.info(">>> empleados/v1 obtenerTodosLosEmpleados ");
		return empleadosServiceImpl.obtenerTodos();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse eliminarEmpleadosById(@PathVariable("id") String id) {
		log.info(">>> empleados/v1 eliminarEmpleadosById ");
		empleadosServiceImpl.remover(id);

		TemplateResponse response = new TemplateResponse("El Cliente se ha dado de baja exitosamente", "200", "");

		return response;
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse actualizarEmpleados(@PathVariable("id") String id, @RequestBody EmpleadosDto empleado) {
		log.info(">>> empleados/v1 actualizarEmpleados ");

		Empleados empleados = empleadosServiceImpl.modificar(id, empleado);

		TemplateResponse response = new TemplateResponse("El Cliente se ha actualizado exitosamente", "200", empleados);

		return response;
	}
}
