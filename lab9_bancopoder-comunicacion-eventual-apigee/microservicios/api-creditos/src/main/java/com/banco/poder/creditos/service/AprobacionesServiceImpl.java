package com.banco.poder.creditos.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banco.poder.creditos.excepciones.AprobacionesNoEncontradoException;
import com.banco.poder.creditos.excepciones.CreditosNoEncontradoException;
import com.banco.poder.creditos.modelo.AprobacionDto;
import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.repository.AprobacionesRepository;
import com.banco.poder.creditos.repository.CreditosRepository;

@Service
public class AprobacionesServiceImpl implements AprobacionesService {

	private AprobacionesRepository aprobacionesRepository;
	private CreditosRepository creditosRepository;

	public AprobacionesServiceImpl(AprobacionesRepository aprobacionesRepository,
			CreditosRepository creditosRepository) {
		this.aprobacionesRepository = aprobacionesRepository;
		this.creditosRepository = creditosRepository;
	}

	@Override
	public void guardar(AprobacionDto aprobacionDto) {

		CreditosDto validate = creditosRepository.buscarById(aprobacionDto.getIdCredito());
		if (validate == null)
			throw new CreditosNoEncontradoException("No se encontro el credito", aprobacionDto.getIdCredito());

		aprobacionDto.setFecha(new Date().toString());
		aprobacionDto.setFechaConfirmacion(new Date().toString());

		aprobacionesRepository.persistir(aprobacionDto);
	}

	@Override
	public List<AprobacionDto> obtenerTodo() {
		return aprobacionesRepository.obtenerTodo();
	}

	@Override
	public AprobacionDto obtenerById(String idCredito) {

		AprobacionDto aprobacionDto = aprobacionesRepository.obtenerById(idCredito);

		if (aprobacionDto == null)
			throw new AprobacionesNoEncontradoException("No se encontro la aprobacion buscada", idCredito);

		return aprobacionDto;
	}
}
