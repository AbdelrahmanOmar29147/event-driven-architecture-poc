package com.sumerge.POSConnector.controllers;

import com.sumerge.POSConnector.models.WebsocketMessage;
import com.sumerge.POSConnector.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController
{
    @Autowired
    KafkaService kafkaService;
    @MessageMapping("/generatePaymentOrderRequest")
    @SendTo("/topic/getPaymentOrderResponse")
    public WebsocketMessage generatePaymentOrderRequest(WebsocketMessage message)
    {
        //Produce from Kafka
        kafkaService.produce(message);
        //Consume from Kafka
        return kafkaService.consumeWebsocket();
    }
}
