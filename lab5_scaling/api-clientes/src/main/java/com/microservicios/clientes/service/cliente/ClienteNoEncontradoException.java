package com.microservicios.clientes.service.cliente;

/**
 * <b>ClienteNoEncontradoException.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 */
public class ClienteNoEncontradoException extends RuntimeException {
  private final String id;

  public ClienteNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static ClienteNoEncontradoException from(String message, String id) {
    return new ClienteNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
