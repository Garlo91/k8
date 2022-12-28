package com.banco.poder.clientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.poder.clientes.entity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, String> {
	Optional<Clientes> findById(String id);
}
