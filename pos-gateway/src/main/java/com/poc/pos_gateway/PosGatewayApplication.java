package com.poc.pos_gateway;

import com.poc.pos_gateway.kafka.producer.GatewayProducer;
import com.poc.pos_gateway.model.dto.kafka.PaymentOrderRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosGatewayApplication {

	@Autowired
	GatewayProducer gatewayProducer;

	public static void main(String[] args) {
		SpringApplication.run(PosGatewayApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			PaymentOrderRequestEvent paymentOrderRequestEvent = new PaymentOrderRequestEvent("78", "0", false, 90, "297");
			// Send the message
			gatewayProducer.sendMessage(paymentOrderRequestEvent);
		};
	}
}
