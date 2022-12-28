package com.microservicios.clientes.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios.clientes.service.cliente.ClienteNoEncontradoException;

/**
 * <b>ApiExceptionHandler.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 */
@RestControllerAdvice
public class ApiExceptionHandler {
  @Autowired
  private ObjectMapper objectMapper;

  @ExceptionHandler(ClienteNoEncontradoException.class)
  public HttpEntity notFound(ClienteNoEncontradoException exception) {

    HashMap<String, Object> body = new HashMap<>();
    body.put("folioCliente", exception.getId());
    body.put("message", exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }
}
