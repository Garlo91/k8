package com.banco.poder.creditos.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.banco.poder.creditos.excepciones.CreditosNoEncontradoException;
import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.modelo.PagosDto;
import com.banco.poder.creditos.modelo.ReferenciasDto;
import com.banco.poder.creditos.modelo.SaldoDto;
import com.banco.poder.creditos.repository.AprobacionesRepository;
import com.banco.poder.creditos.repository.CreditosRepository;
import com.banco.poder.creditos.repository.PagosRepository;
import com.banco.poder.creditos.repository.ReferenciasRepository;
import com.banco.poder.creditos.service.async.AprobacionesProducer;
import com.google.gson.Gson;

@Service
public class CreditosServiceImpl implements CreditosService {

	private CreditosRepository creditosRepository;
	private ReferenciasRepository referenciasRepository;
	private PagosRepository pagosRepository;
	private AprobacionesProducer aprobacionesProducer;
	private Gson json = new Gson();
	private Logger log = Logger.getLogger(CreditosServiceImpl.class);
	private AprobacionesRepository aprobacionesRepository;

	public CreditosServiceImpl(CreditosRepository creditosRepository, ReferenciasRepository referenciasRepository,
			PagosRepository pagosRepository, AprobacionesProducer aprobacionesProducer,
			AprobacionesRepository aprobacionesRepository) {
		this.creditosRepository = creditosRepository;
		this.referenciasRepository = referenciasRepository;
		this.pagosRepository = pagosRepository;
		this.aprobacionesProducer = aprobacionesProducer;
		this.aprobacionesRepository = aprobacionesRepository;
	}

	@Override
	public CreditosDto obtenerById(String id) {

		CreditosDto creditosDto = creditosRepository.buscarById(id);
		if (creditosDto == null)
			throw new CreditosNoEncontradoException("No se encontro el credito", id);

		List<ReferenciasDto> referencias = referenciasRepository.buscarTodo(creditosDto.getIdCredito());
		creditosDto.setReferencias(referencias);

		return creditosDto;
	}

	@Override
	public CreditosDto modificar(String id, CreditosDto creditosDto) {

		CreditosDto validate = creditosRepository.buscarById(id);
		if (validate == null)
			throw new CreditosNoEncontradoException("No se encontro el credito", id);

		CreditosDto creditosDto2 = creditosRepository.actualizar(id, creditosDto);

		List<ReferenciasDto> referencias = referenciasRepository.buscarTodo(creditosDto2.getIdCredito());
		creditosDto2.setReferencias(referencias);

		return creditosDto2;
	}

	@Override
	public CreditosDto guardar(CreditosDto creditosDto) {
		creditosDto.setFecha(new Date().toString());

		CreditosDto credito = creditosRepository.persistir(creditosDto);

		creditosDto.getReferencias()
				.forEach(referencias -> referenciasRepository.persistir(credito.getIdCredito(), referencias));

		List<ReferenciasDto> referencias = referenciasRepository.buscarTodo(credito.getIdCredito());

		credito.setReferencias(referencias);

		/*
		 * Envia solicitud de autorizacion para el area de verificacion de la empresa
		 */
		aprobacionesProducer.sendMessage(json.toJson(credito));
		log.info(">>>Envia solicitud de autorizacion para el area de verificacion de la empresa ok");

		return credito;
	}

	@Override
	public void borrar(String id) {

		/*
		 * Se eliminan las referencias del credito
		 */
		referenciasRepository.eliminar(id);
		aprobacionesRepository.eliminar(id);
		pagosRepository.eliminar(id);

		creditosRepository.eliminar(id);

	}

	@Override
	public SaldoDto obtenerSaldo(String idCredito) {
		// TODO Auto-generated method stub

		SaldoDto saldoDto = new SaldoDto();

		CreditosDto creditosDto = obtenerById(idCredito);

		if (creditosDto == null)
			throw new CreditosNoEncontradoException("No se encontro el credito", idCredito);

		List<PagosDto> pagos = pagosRepository.consultarTodo(idCredito);

		double montoPagos = 0;
		double montoLiquidar = 0;
		for (PagosDto pagoi : pagos) {
			montoPagos += pagoi.getImporte();
		}
		montoLiquidar = creditosDto.getMonto() - montoPagos;

		/*
		 * Monto de pagos realizados
		 */
		saldoDto.setMonto(montoPagos);
		/*
		 * Cantidad a liquidar, monto - pagos
		 */
		saldoDto.setMontoLiquidacion(montoLiquidar);
		saldoDto.setIdCredito(idCredito);

		return saldoDto;
	}

}