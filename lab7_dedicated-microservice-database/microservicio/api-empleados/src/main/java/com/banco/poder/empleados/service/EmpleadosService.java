package com.banco.poder.empleados.service;

import java.util.List;

import com.banco.poder.empleados.entity.Empleados;
import com.banco.poder.empleados.modelo.EmpleadosDto;

public interface EmpleadosService {

	List<Empleados> obtenerTodos();
	Empleados obtenerById(String id);
	Empleados guardar(EmpleadosDto empleadosDto);
	void remover(String id);
	Empleados modificar(String id, EmpleadosDto empleadosDto);
}
