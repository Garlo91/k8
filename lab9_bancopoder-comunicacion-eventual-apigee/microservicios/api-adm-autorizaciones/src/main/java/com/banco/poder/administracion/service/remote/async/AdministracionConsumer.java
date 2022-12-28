package com.banco.poder.administracion.service.remote.async;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.banco.poder.administracion.RabbitConfigConsumer;
import com.banco.poder.administracion.entity.Autorizaciones;
import com.banco.poder.administracion.modelo.SegurosDto;
import com.banco.poder.administracion.service.AdministracionServiceImpl;
import com.google.gson.Gson;

@Component
public class AdministracionConsumer {

	public static final Logger logger = LoggerFactory.getLogger(AdministracionConsumer.class);
	private Gson json = new Gson();
	private AdministracionServiceImpl administracionServiceImpl;

	public AdministracionConsumer(AdministracionServiceImpl administracionServiceImpl) {
		this.administracionServiceImpl = administracionServiceImpl;
	}

	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_ADMINISTRACION_AUTORIZACION)
	public void listenConfirmaciones(Message message) {
		String body = new String(message.getBody());
		logger.info("Event autorizaciones" + body);
		
			Autorizaciones entities = new Autorizaciones();
				entities.setDatosValidacion(json.toJson(body));
				entities.setEstatus(Boolean.FALSE);
				entities.setFechaApertura(new Date().toString());

		administracionServiceImpl.guardarAutorizaciones(entities);
	}
}
