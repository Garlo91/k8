package com.banco.poder.creditos.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.banco.poder.creditos.RabbitConfigConsumer;
import com.banco.poder.creditos.modelo.AprobacionDto;
import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.modelo.remote.ConfirmacionDto;
import com.banco.poder.creditos.service.AprobacionesService;
import com.google.gson.Gson;

@Component
public class ConfirmacionCreditoConsumer {

	public static final Logger logger = LoggerFactory.getLogger(ConfirmacionCreditoConsumer.class);
	private AprobacionesService aprobacionesService;
	private Gson json = new Gson();

	public ConfirmacionCreditoConsumer(AprobacionesService aprobacionesService) {
		this.aprobacionesService = aprobacionesService;
	}

	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_ADMINISTRACION_CONFIRMACION)
	public void listenConfirmaciones(Message message) {
		String body = new String(message.getBody());
		logger.info("Event confirmacion del adm de autorizaciones" + body);

		AprobacionDto aprobacionDto = new AprobacionDto();

		ConfirmacionDto confirmacionDto = json.fromJson(body, ConfirmacionDto.class); 
		
		String transforma = confirmacionDto.getDatosValidacion().replace("\"{", "{").replace("\\", "").replace("}\"", "}");
		
		CreditosDto creditosDto = json.fromJson(transforma, CreditosDto.class);

		aprobacionDto.setIdCredito(creditosDto.getIdCredito());
		aprobacionDto.setEstatus(confirmacionDto.getAutorizacion());

		aprobacionesService.guardar(aprobacionDto);
		
		logger.info("creditos autorizaciones ok");
	}
}
