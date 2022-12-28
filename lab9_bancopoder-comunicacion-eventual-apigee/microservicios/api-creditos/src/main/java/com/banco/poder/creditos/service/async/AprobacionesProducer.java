package com.banco.poder.creditos.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.banco.poder.creditos.RabbitConfigConsumer;
@Component
public class AprobacionesProducer {

	private RabbitTemplate rabbitTemplate;

	public static final Logger logger = LoggerFactory.getLogger(AprobacionesProducer.class);

	public AprobacionesProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_ADMINISTRACION_AUTORIZACION, contractEvent);
		logger.info(">>>Envio de autorizacion correctamente...");
	}
}
