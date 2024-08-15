package com.poc.pos_gateway.model.dto.kafka.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRefundRequestEvent {
//    private String requestId;
    private String originalMerchantRefNum;
    private String amount;
    private String terminalId;
}
