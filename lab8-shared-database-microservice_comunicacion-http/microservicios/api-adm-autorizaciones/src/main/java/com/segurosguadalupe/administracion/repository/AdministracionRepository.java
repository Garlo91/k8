package com.segurosguadalupe.administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.segurosguadalupe.administracion.entity.Autorizaciones;
@Repository
public interface AdministracionRepository extends JpaRepository<Autorizaciones, String> {

}
