package com.poc.pos_gateway.repositories.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "payment_orders")
public class PaymentOrder {
    @Id
    private String id;
    @NotBlank
    private String operationId;
    @NotBlank
    private String messageId;
    @NotBlank
    private String merchantRefNum;
//    private LocalDateTime timeStamp;
    @NotBlank
    private String amount;
    private String convenienceFee;
    private Boolean tip;
    @NotBlank
    private Integer validity;
    @NotBlank
    private String terminalId;
    private String qrCode;
    private String merchantId;
    private String customerRef;
    private String transactionStatus;
    private String customerIpa;
    private String originalMerchantRefNum;
}
