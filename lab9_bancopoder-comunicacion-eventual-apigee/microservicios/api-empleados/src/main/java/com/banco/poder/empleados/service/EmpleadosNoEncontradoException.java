package com.banco.poder.empleados.service;

public class EmpleadosNoEncontradoException extends RuntimeException {
  private final String id;

  public EmpleadosNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static EmpleadosNoEncontradoException from(String message, String id) {
    return new EmpleadosNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
