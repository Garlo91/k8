package com.banco.poder.creditos.excepciones;

public class AprobacionesNoEncontradoException extends RuntimeException {
  private final String id;

  public AprobacionesNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static AprobacionesNoEncontradoException from(String message, String id) {
    return new AprobacionesNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
