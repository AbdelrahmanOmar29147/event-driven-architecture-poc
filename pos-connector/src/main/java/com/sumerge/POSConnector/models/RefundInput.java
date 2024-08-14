package com.sumerge.POSConnector.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RefundInput
{
    String requestId;
    String merchantRefNum;
    String timeStamp;
    String originalMerchantRefNum;
    String amount;
    String terminalId;
}
