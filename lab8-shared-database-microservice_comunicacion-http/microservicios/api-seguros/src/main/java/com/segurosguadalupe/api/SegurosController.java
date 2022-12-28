package com.segurosguadalupe.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.segurosguadalupe.entity.Catalogos;
import com.segurosguadalupe.modelo.ConfirmacionResumenDto;
import com.segurosguadalupe.modelo.PolizaDto;
import com.segurosguadalupe.modelo.SegurosDto;
import com.segurosguadalupe.modelo.remote.ConfirmacionDto;
import com.segurosguadalupe.service.SegurosServiceImpl;

@RestController
@RequestMapping("seguros/v1")
public class SegurosController {

	private static final Logger log = Logger.getLogger(SegurosController.class);
	@Autowired
	private SegurosServiceImpl segurosService;

	@PostMapping
	@ResponseStatus(CREATED)
	public PolizaDto crear(@RequestBody SegurosDto seguros) {
		log.info(">>> seguros/v1 creando seguro");
		return segurosService.poliza(seguros);
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public SegurosDto obtenerPoliza(@PathVariable("id") String id) {
		log.info(">>> seguros/v1 obtenerPoliza ");
		return segurosService.obtenerSeguroById(id).to();
	}

	@GetMapping("/catalogos")
	@ResponseStatus(OK)
	public List<Catalogos> leerCatalogos() {
		log.info(">>> seguros/v1/catalogos leerCatalogos ");

		return segurosService.obtenerCatSeguros();
	}

	@PutMapping("/confirmaciones")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto confirmacionSeguro(@RequestBody ConfirmacionDto confirmacion) {
		return segurosService.modificaSeguro(confirmacion);
	}
}
