package com.poc.pos_gateway.kafka.producer;

import com.poc.pos_gateway.common.Topics;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentOrderRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentRefundRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentOrderResponseEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentRefundResponseEvent;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GatewayProducer {
    private final KafkaTemplate<Object, EventModel<?>> kafkaTemplate;

    //IMPLEMENTATION
    public void sendPaymentOrderResponse(EventModel<PaymentOrderResponseEvent> paymentOrderResponse) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_RESPONSE, paymentOrderResponse);
    }

    public void sendPaymentRefundResponse(EventModel<PaymentRefundResponseEvent> paymentRefundResponse) {
        kafkaTemplate.send(Topics.PAYMENT_REFUND_RESPONSE, paymentRefundResponse);
    }
}
