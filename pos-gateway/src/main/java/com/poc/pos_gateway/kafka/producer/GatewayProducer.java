package com.poc.pos_gateway.kafka.producer;

import com.poc.pos_gateway.common.Topics;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.PaymentOrderRequestEvent;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GatewayProducer {
    private final KafkaTemplate<Object, EventModel<?>> kafkaTemplate;

    //IMPLEMENTATION
    public void sendPaymentOrderResponse(PaymentOrderRequestEvent paymentOrder) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_REQUEST, new EventModel<PaymentOrderRequestEvent>("generatePaymentOrderRequest", "1273", "19995", paymentOrder));
    }

    public void sendPaymentRefundResponse(PaymentOrderRequestEvent paymentOrder) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_REQUEST, new EventModel<PaymentOrderRequestEvent>("generatePaymentOrderRequest", "1273", "19995", paymentOrder));
    }

    //TESTING(TO BE REMOVED)
    public void sendPaymentOrderRequest(PaymentOrderRequestEvent paymentOrder) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_REQUEST, new EventModel<PaymentOrderRequestEvent>("generatePaymentOrderRequest", "1273", "19995", paymentOrder));
    }
    public void sendPaymentRefundRequest(PaymentOrderRequestEvent paymentOrder) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_REQUEST, new EventModel<PaymentOrderRequestEvent>("generatePaymentOrderRequest", "1273", "19995", paymentOrder));
    }
}
