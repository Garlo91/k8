package com.banco.poder.creditos.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.poder.creditos.modelo.AprobacionDto;
import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.modelo.DetallePagosDto;
import com.banco.poder.creditos.modelo.PagosDto;
import com.banco.poder.creditos.modelo.SaldoDto;
import com.banco.poder.creditos.modelo.TemplateResponse;
import com.banco.poder.creditos.service.AprobacionesService;
import com.banco.poder.creditos.service.CreditosServiceImpl;
import com.banco.poder.creditos.service.PagosService;

@RestController
@RequestMapping("creditos/v1")
public class CreditosController {

	private static final Logger log = Logger.getLogger(CreditosController.class);

	private CreditosServiceImpl creditosServiceImpl;
	private AprobacionesService aprobacionesService;
	private PagosService pagosService;

	public CreditosController(CreditosServiceImpl creditosServiceImpl, AprobacionesService aprobacionesService,
			PagosService pagosService) {
		this.creditosServiceImpl = creditosServiceImpl;
		this.aprobacionesService = aprobacionesService;
		this.pagosService = pagosService;
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody CreditosDto creditosDto) {
		log.info(">>> creditos/v1 creando creditos, wuju dinero!!");

		CreditosDto creditos = creditosServiceImpl.guardar(creditosDto);

		TemplateResponse response = new TemplateResponse("El Credito se ha creado exitosamente", "201", creditos);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public CreditosDto consultarCreditosById(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 consultarCreditosById ");

		return creditosServiceImpl.obtenerById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse modificarCreditos(@PathVariable("id") String id, @RequestBody CreditosDto creditosDto) {
		log.info(">>> creditos/v1 modificarCreditos ");

		CreditosDto creditos = creditosServiceImpl.modificar(id, creditosDto);

		TemplateResponse response = new TemplateResponse("El Credito se ha actualizado exitosamente", "200", creditos);

		return response;

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse borrarCreditoById(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 borrarCreditoById ");

		creditosServiceImpl.borrar(id);

		TemplateResponse response = new TemplateResponse("La solicitud de credito se ha dado de baja exitosamente",
				"200", "");

		return response;
	}

	@PostMapping("/aprobaciones")
	@ResponseStatus(CREATED)
	public TemplateResponse crearAprobacion(@RequestBody AprobacionDto aprobacionDto) {
		log.info(">>> creditos/v1 crearAprobacion");

		aprobacionesService.guardar(aprobacionDto);

		TemplateResponse response = new TemplateResponse("Procesando autorizacion de credito", "201", "");

		return response;
	}

	@GetMapping("/aprobaciones")
	@ResponseStatus(OK)
	public List<AprobacionDto> aprobacionesTodo() {
		log.info(">>> creditos/v1 aprobacionesTodo");

		return aprobacionesService.obtenerTodo();
	}

	@GetMapping("/aprobaciones/{id}")
	@ResponseStatus(OK)
	public AprobacionDto aprobaciones(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 aprobaciones");

		return aprobacionesService.obtenerById(id);
	}

	@GetMapping("/{id}/saldos")
	@ResponseStatus(OK)
	public SaldoDto saldos(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 saldos");

		return creditosServiceImpl.obtenerSaldo(id);
	}

	@PostMapping("/pagos")
	@ResponseStatus(CREATED)
	public TemplateResponse pagos(@RequestBody PagosDto pagosDto) {
		log.info(">>> creditos/v1 pagos");

		PagosDto pagosDto2 = pagosService.guardar(pagosDto);

		TemplateResponse response = new TemplateResponse("El pago se realizo exitosamente", "201", pagosDto2);

		return response;
	}
	
	@GetMapping("/pagos/{id}")
	@ResponseStatus(OK)
	public PagosDto pagosById(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 pagosById");

		return pagosService.obtenerById(id);
	}

	@GetMapping("/{id}/pagos")
	@ResponseStatus(OK)
	public DetallePagosDto detallePagos(@PathVariable("id") String id) {
		log.info(">>> creditos/v1 detallePagos");

		return pagosService.obtenerDetalle(id);
	}

}
