package com.sumerge.POSConnector.kafka.producer;


import com.sumerge.POSConnector.common.Topics;
import com.sumerge.POSConnector.models.EventModel;
import com.sumerge.POSConnector.models.RefundInput;
import com.sumerge.POSConnector.models.WebsocketMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GatewayProducer {
    private final KafkaTemplate<String, EventModel> kafkaTemplate;

    public void sendMessage(RefundInput refundInput) {
        kafkaTemplate.send(Topics.PAYMENT_REFUND_REQUEST, new EventModel<RefundInput>("PaymentRefund", refundInput.getRequestId(), refundInput.getMerchantRefNum(), refundInput));
    }
    public void sendMessage(WebsocketMessage message) {
        kafkaTemplate.send(Topics.PAYMENT_ORDER_REQUEST, new EventModel<WebsocketMessage>("generatePaymentOrderRequest", message.getMessageId(), message.getMerchantRefNum(), message));
    }
}
