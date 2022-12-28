package com.microservicios.clientes.service.cliente;

import com.microservicios.clientes.modelo.ClienteBean;
import com.microservicios.clientes.service.creditos.modelo.Credito;
import com.microservicios.clientes.service.creditos.modelo.ResumenCredito;

/**
 * <b>ClientesService.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 */
public interface ClientesService {

    ClienteBean guardarCliente(ClienteBean clienteBean);
    ClienteBean consultarCliente(String idCliente);
    void borrarCliente(String idCliente);
    void modificar(String idCliente);
    ResumenCredito generarCredito(Credito credito);

}
