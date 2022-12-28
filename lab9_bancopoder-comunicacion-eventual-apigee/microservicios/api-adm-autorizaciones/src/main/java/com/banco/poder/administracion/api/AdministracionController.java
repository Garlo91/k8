package com.banco.poder.administracion.api;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.poder.administracion.entity.Autorizaciones;
import com.banco.poder.administracion.modelo.AutorizacionDto;
import com.banco.poder.administracion.modelo.AutorizacionesResumenDto;
import com.banco.poder.administracion.service.AdministracionServiceImpl;

@RestController
@RequestMapping("administracion/v1")
public class AdministracionController {

	private static final Logger log = Logger.getLogger(AdministracionController.class);
	@Autowired
	private AdministracionServiceImpl administracionServiceImpl;

	@GetMapping
	@ResponseStatus(OK)
	public List<Autorizaciones> leerAutorizaciones(){
		return administracionServiceImpl.obtenerAutorizaciones();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Autorizaciones autorizacion(@PathVariable("id")String id){
		return administracionServiceImpl.obtenerAutorizacion(id);
	}
	
	@PutMapping("/autorizaciones/confirmaciones")
	@ResponseStatus(OK)
	public AutorizacionesResumenDto confirmacion(@RequestBody AutorizacionDto autorizacionDto){
		return administracionServiceImpl.modificaById(autorizacionDto.getIdAutorizacion(), autorizacionDto.getConfirmacion());
	}
	
}
