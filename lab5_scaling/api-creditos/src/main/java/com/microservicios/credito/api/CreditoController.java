package com.microservicios.credito.api;

import static org.springframework.http.HttpStatus.CREATED;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.credito.modelo.Credito;
import com.microservicios.credito.modelo.ResumenCredito;
import com.microservicios.credito.service.CreditoServiceImpl;

@RestController
@RequestMapping("api/v1/creditos")
public class CreditoController {

	@Autowired
	private CreditoServiceImpl creditoServiceImpl;
	private static Logger log = Logger.getLogger(CreditoController.class);

	@PostMapping
	@ResponseStatus(CREATED)
	public ResumenCredito add(@RequestBody Credito credito) {
		log.info(">>> Generando credito api/v1/creditos");

		return creditoServiceImpl.generarCredito(credito);
	}

}
