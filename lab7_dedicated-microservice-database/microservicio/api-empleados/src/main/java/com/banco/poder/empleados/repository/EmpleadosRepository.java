package com.banco.poder.empleados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.poder.empleados.entity.Empleados;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, String> {
	Optional<Empleados> findById(String id);
}
