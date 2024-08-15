package com.poc.pos_gateway.model.dto.kafka.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrderRequestEvent {
    String operationId;
    String messageId;
    String merchantRefNum;
    String timeStamp;
    PaymentOrderRequestObject data;
}
