package com.segurosguadalupe.administracion.service;

public class AdministracionNoEncontradoException extends RuntimeException {
  private final String id;

  public AdministracionNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static AdministracionNoEncontradoException from(String message, String id) {
    return new AdministracionNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
