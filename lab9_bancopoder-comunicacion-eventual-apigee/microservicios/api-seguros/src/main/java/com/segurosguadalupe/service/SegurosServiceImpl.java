package com.segurosguadalupe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.segurosguadalupe.entity.Catalogos;
import com.segurosguadalupe.entity.Seguros;
import com.segurosguadalupe.modelo.ConfirmacionResumenDto;
import com.segurosguadalupe.modelo.PolizaDto;
import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.AutorizacionesResumenDto;
import com.segurosguadalupe.modelo.remote.ConfirmacionDto;
import com.segurosguadalupe.repository.CatalogosRepository;
import com.segurosguadalupe.repository.SegurosRepository;
import com.segurosguadalupe.service.remote.AdministracionSegurosServiceRemote;

@Service
public class SegurosServiceImpl implements SegurosService {

	private SegurosRepository segurosRepository;
	private CatalogosRepository catalogosRepository;
	private AdministracionSegurosServiceRemote admServiceRemote;
	private Logger log = Logger.getLogger(SegurosServiceImpl.class);
	
	
	public SegurosServiceImpl(SegurosRepository segurosRepository, CatalogosRepository catalogosRepository,
			AdministracionSegurosServiceRemote admServiceRemote) {
		this.segurosRepository = segurosRepository;
		this.catalogosRepository = catalogosRepository;
		this.admServiceRemote = admServiceRemote;
	}

	@Override
	public Seguros guardarSeguros(SegurosDto seguros) {

		Seguros seguros2 = segurosRepository.saveAndFlush(Seguros.from(seguros));

		return seguros2;
	}

	@Override
	public List<Catalogos> obtenerCatSeguros() {
		return catalogosRepository.findByEstatus(Boolean.TRUE);
	}

	@Override
	public Seguros obtenerSeguroById(String id) {

		return segurosRepository.findById(id)
				.orElseThrow(() -> SeguroNoEncontradoException.from("No se encontro el seguro", id));
	}

	@Transactional
	@Override
	public PolizaDto poliza(SegurosDto seguros) {

		Seguros seguros2 = guardarSeguros(seguros);

		/*
		 * Envia solicitud de autorizacion para el area de verificacion de seguros
		 */
		AutorizacionesResumenDto autorizaciones = admServiceRemote.solicitaAutorizacion(seguros2.to());
		log.info(">>>Envia solicitud de autorizacion para el area de verificacion de seguros");

		PolizaDto poliza = new PolizaDto();
			poliza.setFolio(seguros2.getId());
				poliza.setMensaje("Datos de la poliza");
			poliza.setSeguros(seguros2.to());
			poliza.setAutorizaciones(autorizaciones);

		return poliza;
	}

	@Override
	public ConfirmacionResumenDto modificaSeguro(ConfirmacionDto confirmacion) {
		
		Seguros seguros = segurosRepository.findById(confirmacion.getIdSeguro())
			.orElseThrow(() -> SeguroNoEncontradoException.from("No se encontro el seguro", confirmacion.getIdSeguro()));
		
			seguros.setAutorizacion(confirmacion.getAutorizacion());
			
			seguros = segurosRepository.save(seguros);
			
			ConfirmacionResumenDto confirmacionResumenDto =new ConfirmacionResumenDto();
			confirmacionResumenDto.setFolio(seguros.getId());
			confirmacionResumenDto.setMensaje("Confirmacion de seguro, favor de validar estatus");
		
			return confirmacionResumenDto;
	}

}
