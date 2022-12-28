package com.banco.poder.creditos.excepciones;

public class PagosNoEncontradoException extends RuntimeException {
  private final String id;

  public PagosNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static PagosNoEncontradoException from(String message, String id) {
    return new PagosNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
