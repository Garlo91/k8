package com.banco.poder.administracion.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.poder.administracion.entity.Autorizaciones;
import com.banco.poder.administracion.modelo.AutorizacionesResumenDto;
import com.banco.poder.administracion.modelo.ConfirmacionDto;
import com.banco.poder.administracion.repository.AdministracionRepository;
import com.banco.poder.administracion.service.remote.async.AdministracionProducer;
import com.google.gson.Gson;

@Service
public class AdministracionServiceImpl implements AdministracionService {

	@Autowired
	private AdministracionRepository administracionRepository;

	Gson json = new Gson();
	private Logger log = Logger.getLogger(AdministracionServiceImpl.class);
	@Autowired
	private AdministracionProducer administracionProducer;


	@Transactional
	@Override
	public AutorizacionesResumenDto guardarAutorizaciones(Autorizaciones autorizaciones) {

	
		Autorizaciones autorizacion = administracionRepository.save(autorizaciones);

		AutorizacionesResumenDto autorizacionesResumenDto = new AutorizacionesResumenDto();
		autorizacionesResumenDto.setFolio(autorizacion.getIdAutorizacion());
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
			Autorizaciones autorizacionesUpdate  = administracionRepository.save(autorizaciones);
		log.info(">>>Actualiza autorizacion...");

		
		ConfirmacionDto confirmacionDto = new ConfirmacionDto();
			confirmacionDto.setAutorizacion(autorizacionesUpdate.isEstatus());
			confirmacionDto.setIdAutorizacion(autorizacionesUpdate.getIdAutorizacion());
			confirmacionDto.setDatosValidacion(autorizacionesUpdate.getDatosValidacion());
			
			administracionProducer.sendMessage(json.toJson(confirmacionDto));
		log.info(">>>Se notifico el estatus del la autorizacion...");

		return new AutorizacionesResumenDto(autorizaciones.getIdAutorizacion(),"Se proceso la solicitud validacion");
	}

}
