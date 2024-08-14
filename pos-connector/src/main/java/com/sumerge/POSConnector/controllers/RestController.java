package com.sumerge.POSConnector.controllers;

import com.sumerge.POSConnector.models.RefundInput;
import com.sumerge.POSConnector.models.RefundOutput;
import com.sumerge.POSConnector.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    @Autowired
    KafkaService kafkaService;
    @PostMapping("/payment-refund")
    public RefundOutput paymentRefund(@RequestBody RefundInput request) {
        //Produce from Kafka
        kafkaService.produce(request);
        //Consume from Kafka
        return kafkaService.consumeRest();
    }
}
