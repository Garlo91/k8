package com.segurosguadalupe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.segurosguadalupe.entity.Catalogos;
@Repository
public interface CatalogosRepository extends JpaRepository<Catalogos, String> {
	List<Catalogos> findByEstatus(boolean estatus);
}
