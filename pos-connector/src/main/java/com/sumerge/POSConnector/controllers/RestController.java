package com.sumerge.POSConnector.controllers;

import com.sumerge.POSConnector.kafka.consumer.GatewayConsumer;
import com.sumerge.POSConnector.kafka.producer.GatewayProducer;
import com.sumerge.POSConnector.models.RefundInput;
import com.sumerge.POSConnector.models.RefundOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ExecutionException;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    @Autowired
    GatewayProducer gatewayProducer;
    @Autowired
    GatewayConsumer gatewayConsumer;
    @PostMapping("/payment-refund")
    public RefundOutput paymentRefund(@RequestBody RefundInput request) throws ExecutionException, InterruptedException {
        //Produce from Kafka
        gatewayProducer.sendMessage(request);
        //Consume from Kafka
        return gatewayConsumer.getRefundFuture().get();
    }
}
