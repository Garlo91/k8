package com.banco.poder.creditos.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.banco.poder.creditos.excepciones.AprobacionesNoEncontradoException;
import com.banco.poder.creditos.excepciones.CreditosNoEncontradoException;
import com.banco.poder.creditos.excepciones.PagosNoEncontradoException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class ApiExceptionHandler {
	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler(CreditosNoEncontradoException.class)
	public HttpEntity notFound(CreditosNoEncontradoException exception) {

		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(AprobacionesNoEncontradoException.class)
	public HttpEntity notFoundAprobaciones(AprobacionesNoEncontradoException exception) {

		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(PagosNoEncontradoException.class)
	public HttpEntity notFoundPagos(PagosNoEncontradoException exception) {

		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
}
