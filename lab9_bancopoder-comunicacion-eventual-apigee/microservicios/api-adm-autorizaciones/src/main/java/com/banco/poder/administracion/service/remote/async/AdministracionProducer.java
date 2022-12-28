package com.banco.poder.administracion.service.remote.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.banco.poder.administracion.RabbitConfigConsumer;
@Component
public class AdministracionProducer {

	private RabbitTemplate rabbitTemplate;

	public static final Logger logger = LoggerFactory.getLogger(AdministracionProducer.class);

	public AdministracionProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_ADMINISTRACION_CONFIRMACION, contractEvent);
		logger.info(">>>Envio de confirmacion a seguros...");
	}
}
