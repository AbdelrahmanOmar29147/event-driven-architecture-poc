package com.poc.pos_gateway.model.dto.kafka.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRefundResponseEvent {
//    private String requestId;
    private String merchantId;
    private String customerRef;
    private String transactionStatus;
    private String customerIpa;
    private String amount;
}
