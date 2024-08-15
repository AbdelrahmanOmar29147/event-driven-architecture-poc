package com.poc.pos_gateway.model.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrderRequestEvent {
    private String amount;
    private String convenienceFee;
    private Boolean tip;
    private Integer validity;
    private String terminalId;
}
