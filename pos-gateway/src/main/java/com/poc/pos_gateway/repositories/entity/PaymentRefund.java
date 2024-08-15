package com.poc.pos_gateway.repositories.entity;

import com.poc.pos_gateway.common.Direction;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payment_refunds")
public class PaymentRefund {
    @NotBlank
    String requestId;

    @NotBlank
    String merchantRefNum;

    //timeStamp is supposed to be of a date type with this format YYYY-MM-DD hh:mm:ss.ttt
    @NotBlank
    String timeStamp;

    String originalMerchantRefNum;

    String merchantId;

    @NotBlank
    String amount;

    String terminalId;

    String customerRef;

    String transactionStatus;

    String customerIpa;

    @NotBlank
    private Direction direction;

}
