package com.poc.pos_gateway.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.pos_gateway.common.Topics;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.PaymentOrderRequestEvent;
import com.poc.pos_gateway.service.GatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayConsumer {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    private final GatewayService gatewayService;

    @KafkaListener(topics = Topics.PAYMENT_ORDER_REQUEST)
    public void paymentOrderRequestListener(EventModel<PaymentOrderRequestEvent> event) {
        PaymentOrderRequestEvent paymentOrderRequestEvent = MAPPER.convertValue(event.getBody(), PaymentOrderRequestEvent.class);
        event.setBody(paymentOrderRequestEvent);
        gatewayService.processAndSaveEvent(event);
    }

    @KafkaListener(topics = Topics.PAYMENT_REFUND_REQUEST)
    public void paymentRefundRequestListener(EventModel<PaymentOrderRequestEvent> event) {
        PaymentOrderRequestEvent paymentOrderRequestEvent = MAPPER.convertValue(event.getBody(), PaymentOrderRequestEvent.class);
        event.setBody(paymentOrderRequestEvent);
        gatewayService.processAndSaveEvent(event);
    }
}
