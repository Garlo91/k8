package com.banco.poder.administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.poder.administracion.entity.Autorizaciones;
@Repository
public interface AdministracionRepository extends JpaRepository<Autorizaciones, String> {

}
