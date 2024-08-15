package com.sumerge.POSConnector.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumerge.POSConnector.common.Topics;
import com.sumerge.POSConnector.models.EventModel;
import com.sumerge.POSConnector.models.RefundInput;
import com.sumerge.POSConnector.models.RefundOutput;
import com.sumerge.POSConnector.models.WebsocketMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayConsumer {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    private CompletableFuture<RefundOutput> refundFuture = new CompletableFuture<>();
    private CompletableFuture<WebsocketMessage> paymentOrderFuture = new CompletableFuture<>();

    @KafkaListener(topics = Topics.PAYMENT_ORDER_RESPONSE)
    public void paymentOrderRequestListenerWebsocket(EventModel<WebsocketMessage> event) {
        log.info("KAFKA IS ALIVE!: " + event.toString());
        WebsocketMessage paymentOrderRequestEvent = MAPPER.convertValue(event.getBody(), WebsocketMessage.class);
        log.info("KAFKA IS ALIVE!: " + paymentOrderRequestEvent.toString());
        event.setBody(paymentOrderRequestEvent);

        paymentOrderFuture.complete(paymentOrderRequestEvent);
    }
    @KafkaListener(topics = Topics.PAYMENT_REFUND_RESPONSE)
    public void paymentOrderRequestListener(EventModel<RefundOutput> event) {
        log.info("KAFKA IS ALIVE!: " + event.toString());
        RefundOutput refundOutput = MAPPER.convertValue(event.getBody(), RefundOutput.class);
        log.info("KAFKA IS ALIVE!: " + refundOutput.toString());
        event.setBody(refundOutput);

        refundFuture.complete(refundOutput);
    }
    public CompletableFuture<RefundOutput> getRefundFuture() {
        refundFuture = new CompletableFuture<>(); // Reset for the next request
        return refundFuture;
    }
    public CompletableFuture<WebsocketMessage> getPaymentOrderFuture() {
        paymentOrderFuture = new CompletableFuture<>(); // Reset for the next request
        return paymentOrderFuture;
    }

}
