package com.poc.pos_gateway.model.dto.kafka.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRefundResponseEvent {
    String requestId;
    String merchantRefNum;
    String timeStamp;
    String merchantId;
    String customerRef;
    String transactionStatus;
    String customerIpa;
    String amount;
}
