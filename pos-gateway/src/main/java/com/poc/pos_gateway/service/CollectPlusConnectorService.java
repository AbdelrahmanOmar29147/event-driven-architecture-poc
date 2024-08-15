package com.poc.pos_gateway.service;

import com.poc.pos_gateway.kafka.producer.GatewayProducer;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentOrderRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentOrderResponseObject;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentRefundRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentOrderResponseEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentRefundResponseEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CollectPlusConnectorService {

    private final GatewayService gatewayService;

    private final GatewayProducer gatewayProducer;

    public void handleAndForwardPaymentOrderRequest(EventModel<PaymentOrderRequestEvent> paymentOrderRequest){
        gatewayService.savePaymentOrderRequestEvent(paymentOrderRequest);
        PaymentOrderResponseEvent paymentOrderResponse = new PaymentOrderResponseEvent(paymentOrderRequest.getBody().getOperationId(),
                paymentOrderRequest.getBody().getMessageId(),
                paymentOrderRequest.getBody().getMerchantRefNum(),
                paymentOrderRequest.getBody().getTimeStamp(),
                new PaymentOrderResponseObject("\"I AM A VERY VALID QR CODE\""));
        EventModel<PaymentOrderResponseEvent> producedEvent = new EventModel<PaymentOrderResponseEvent>(paymentOrderRequest.getMessageId(), paymentOrderRequest.getMerchantRefNum(), paymentOrderResponse);
        gatewayService.savePaymentOrderResponseEvent(producedEvent);
        gatewayProducer.sendPaymentOrderResponse(producedEvent);
    }

    public void handleAndForwardPaymentRefundRequest(EventModel<PaymentRefundRequestEvent> paymentRefundRequest){
        gatewayService.savePaymentRefundRequestEvent(paymentRefundRequest);
        PaymentRefundResponseEvent paymentRefundResponse = new PaymentRefundResponseEvent("9990", "231412", "APPROVED", "12341234","Test for refund","APPROVED","Test",paymentRefundRequest.getBody().getAmount());
        EventModel<PaymentRefundResponseEvent> producedEvent = new EventModel<PaymentRefundResponseEvent>(paymentRefundRequest.getMessageId(), paymentRefundRequest.getMerchantRefNum(), paymentRefundResponse);
        gatewayService.savePaymentRefundResponseEvent(producedEvent);
        gatewayProducer.sendPaymentRefundResponse(producedEvent);
    }
}
