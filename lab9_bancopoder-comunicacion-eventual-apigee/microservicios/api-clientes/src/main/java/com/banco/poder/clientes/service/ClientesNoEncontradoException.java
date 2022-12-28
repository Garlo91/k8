package com.banco.poder.clientes.service;

public class ClientesNoEncontradoException extends RuntimeException {
  private final String id;

  public ClientesNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static ClientesNoEncontradoException from(String message, String id) {
    return new ClientesNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
