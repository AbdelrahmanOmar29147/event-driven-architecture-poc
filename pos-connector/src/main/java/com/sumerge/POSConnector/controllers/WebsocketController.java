package com.sumerge.POSConnector.controllers;

import com.sumerge.POSConnector.kafka.consumer.GatewayConsumer;
import com.sumerge.POSConnector.kafka.producer.GatewayProducer;
import com.sumerge.POSConnector.models.WebsocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutionException;

@Controller
public class WebsocketController
{
    @Autowired
    GatewayProducer gatewayProducer;
    @Autowired
    GatewayConsumer gatewayConsumer;
    @MessageMapping("/generatePaymentOrderRequest")
    @SendTo("/topic/getPaymentOrderResponse")
    public WebsocketMessage generatePaymentOrderRequest(WebsocketMessage message) throws ExecutionException, InterruptedException {
        //Produce from Kafka
        gatewayProducer.sendMessage(message);
        //Consume from Kafka
        return gatewayConsumer.getPaymentOrderFuture().get();
    }
}
