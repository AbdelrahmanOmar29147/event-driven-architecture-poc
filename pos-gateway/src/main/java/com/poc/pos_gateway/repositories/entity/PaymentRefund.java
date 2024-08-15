package com.poc.pos_gateway.repositories.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payment_refunds")
public class PaymentRefund {
    String requestId;
    String merchantRefNum;
    String timeStamp;
    String originalMerchantRefNum;
    String amount;
    String terminalId;
    String customerRef;
    String transactionStatus;
    String customerIpa;
}
