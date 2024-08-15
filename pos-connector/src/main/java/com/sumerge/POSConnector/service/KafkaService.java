package com.sumerge.POSConnector.service;

import com.sumerge.POSConnector.models.RefundOutput;
import com.sumerge.POSConnector.models.WebsocketMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaService
{
    public void produce(Object o)
    {

    }
    public RefundOutput consumeRest()
    {
        RefundOutput refundOutput = new RefundOutput();
        refundOutput.setAmount("1000");
        refundOutput.setCustomerIpa("Test");
        refundOutput.setRequestId(UUID.randomUUID().toString());
        refundOutput.setMerchantId("Test");
        return refundOutput;
    }
    public WebsocketMessage consumeWebsocket()
    {
        WebsocketMessage message = new WebsocketMessage();
        message.setData(new String("qr"));
        message.setMessageId(UUID.randomUUID().toString());
        message.setOperationId("getPaymentOrderResponse");
        return  message;
    }
}
