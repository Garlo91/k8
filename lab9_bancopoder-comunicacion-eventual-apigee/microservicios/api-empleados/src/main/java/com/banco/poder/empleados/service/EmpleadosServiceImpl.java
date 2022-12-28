package com.banco.poder.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.poder.empleados.entity.Empleados;
import com.banco.poder.empleados.modelo.EmpleadosDto;
import com.banco.poder.empleados.repository.EmpleadosRepository;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Override
	public Empleados obtenerById(String id) {
		return empleadosRepository.findById(id)
				.orElseThrow(() -> EmpleadosNoEncontradoException.from("No se encontro el empleado", id));
	}

	@Override
	public List<Empleados> obtenerTodos() {
		return empleadosRepository.findAll();
	}

	@Override
	public Empleados guardar(EmpleadosDto empleadosDto) {
		Empleados empleados = Empleados.from(empleadosDto);

		return empleadosRepository.save(empleados);
	}

	@Override
	public void remover(String id) {
		
		empleadosRepository.findById(id)
		.orElseThrow(() -> EmpleadosNoEncontradoException.from("No se encontro el empleado", id));
		
		empleadosRepository.delete(id);
	}

	@Override
	public Empleados modificar(String id, EmpleadosDto empleadosDto) {
		Empleados empleados = empleadosRepository.findById(id)
				.orElseThrow(() -> EmpleadosNoEncontradoException.from("No se encontro el empleado", id));

		empleados = empleados.from(empleadosDto);

		empleados = empleadosRepository.save(empleados);

		return empleados;
	}

}
