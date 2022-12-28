package com.segurosguadalupe.administracion.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.segurosguadalupe.administracion.entity.Autorizaciones;
import com.segurosguadalupe.administracion.modelo.AutorizacionesResumenDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionDto;
import com.segurosguadalupe.administracion.modelo.ConfirmacionResumenDto;
import com.segurosguadalupe.administracion.modelo.SegurosDto;
import com.segurosguadalupe.administracion.repository.AdministracionRepository;
import com.segurosguadalupe.administracion.service.remote.SegurosServiceRemote;

@Service
public class AdministracionServiceImpl implements AdministracionService {

	@Autowired
	private AdministracionRepository administracionRepository;
	@Autowired
	private SegurosServiceRemote administracionSegurosServiceRemote;
	Gson json = new Gson();
	private Logger log = Logger.getLogger(AdministracionServiceImpl.class);

	@Transactional
	@Override
	public AutorizacionesResumenDto guardarAutorizaciones(SegurosDto datosSeguro) {

		Autorizaciones entities = new Autorizaciones();
		entities.setDatosPoliza(json.toJson(datosSeguro));
		entities.setEstatus(Boolean.FALSE);
		entities.setFechaApertura(new Date().toString());

		Autorizaciones autorizaciones = administracionRepository.save(entities);

		AutorizacionesResumenDto autorizacionesResumenDto = new AutorizacionesResumenDto();
		autorizacionesResumenDto.setFolio(autorizaciones.getIdAutorizacion());
		autorizacionesResumenDto.setMensaje("La autorizacion se genero correctamente");

		return autorizacionesResumenDto;
	}

	@Override
	public Autorizaciones obtenerAutorizacion(String id) {
		return administracionRepository.findOne(id);
	}

	@Override
	public List<Autorizaciones> obtenerAutorizaciones() {
		return administracionRepository.findAll();
	}

	@Override
	public AutorizacionesResumenDto modificaById(String id, Boolean confirmacion) {

		Autorizaciones autorizaciones = administracionRepository.findOne(id);
		
			autorizaciones.setFechaConfirmacion(new Date().toString());
			autorizaciones.setEstatus(confirmacion);
		
			/*
			 * Actuliza autorizacion
			 */
		administracionRepository.save(autorizaciones);
		log.info(">>>Actuliza autorizacion...");

		SegurosDto segurosDto = json.fromJson(autorizaciones.getDatosPoliza(), SegurosDto.class);
		
		ConfirmacionDto confirmaciones = new ConfirmacionDto();
			confirmaciones.setAutorizacion(confirmacion);
			confirmaciones.setIdSeguro(segurosDto.getId());
		
			ConfirmacionResumenDto resumenConfirmacion = administracionSegurosServiceRemote.confirmacionesPoliza(confirmaciones);
		log.info(">>>Se notifico el estatus de la poliza remotamente...");

		return new AutorizacionesResumenDto(resumenConfirmacion.getFolio(),resumenConfirmacion.getMensaje());
	}

}
