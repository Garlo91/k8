package com.segurosguadalupe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.segurosguadalupe.entity.Seguros;

@Repository
public interface SegurosRepository extends JpaRepository<Seguros, String> {
	Optional<Seguros> findById(String id);
}
