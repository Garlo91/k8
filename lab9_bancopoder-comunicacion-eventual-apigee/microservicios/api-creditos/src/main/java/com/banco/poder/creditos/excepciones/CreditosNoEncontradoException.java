package com.banco.poder.creditos.excepciones;

public class CreditosNoEncontradoException extends RuntimeException {
  private final String id;

  public CreditosNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static CreditosNoEncontradoException from(String message, String id) {
    return new CreditosNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
