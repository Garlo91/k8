package com.banco.poder.creditos;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigConsumer {

	public final static String QUEUE_ADMINISTRACION_AUTORIZACION = "queue-administracion-autorizacion";
	public final static String QUEUE_ADMINISTRACION_CONFIRMACION = "queue-administracion-confirmacion";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_ADMINISTRACION_AUTORIZACION);
	}
	
	@Bean
	Queue queue2() {
		return new Queue(QUEUE_ADMINISTRACION_CONFIRMACION);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-principal");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_ADMINISTRACION_AUTORIZACION);
	}
	
	@Bean
	Binding binding2(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_ADMINISTRACION_CONFIRMACION);
	}
}
