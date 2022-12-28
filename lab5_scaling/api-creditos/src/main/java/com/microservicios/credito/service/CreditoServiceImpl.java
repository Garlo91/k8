package com.microservicios.credito.service;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.credito.modelo.Credito;
import com.microservicios.credito.modelo.ResumenCredito;

@Service
public class CreditoServiceImpl implements CreditoService {

	@Autowired
	private ClientesServiceRemoteClient remoteClient;
	private static Logger log = Logger.getLogger(CreditoServiceImpl.class);



	public ResumenCredito generarCredito(Credito credito) {
		log.info(
				">>>Service generarCredito");

		ResumenCredito credito2 = new ResumenCredito();
		if (validaCliente(credito.getFolioCliente())) {

			credito2.setFolioCredito(String.valueOf(new Random().nextInt()));
			credito2.setFolioCliente(credito.getFolioCliente());
			credito2.setMontoDeuda(credito.getMontoCredito());

		}
		return credito2;

	}

	public boolean validaCliente(String folioCliente) {

		log.info(">>>validaCliente(String folioCliente)");

		if (remoteClient.buscarCliente(folioCliente) != null)
			return true;
		return false;
	}

}
