package com.poc.pos_gateway.model.dto.kafka.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrderResponseEvent  {
    String operationId;
    String messageId;
    String merchantRefNum;
    String timeStamp;
    PaymentOrderResponseObject data;
}
