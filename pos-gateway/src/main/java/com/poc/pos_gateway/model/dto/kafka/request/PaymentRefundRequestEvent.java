package com.poc.pos_gateway.model.dto.kafka.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRefundRequestEvent {
    String requestId;
    String merchantRefNum;
    String timeStamp;
    String originalMerchantRefNum;
    String amount;
    String terminalId;
}
