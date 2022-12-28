package com.segurosguadalupe.service;

public class SeguroNoEncontradoException extends RuntimeException {
  private final String id;

  public SeguroNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static SeguroNoEncontradoException from(String message, String id) {
    return new SeguroNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
