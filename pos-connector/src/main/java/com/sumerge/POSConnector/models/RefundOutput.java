package com.sumerge.POSConnector.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RefundOutput
{
    String requestId;
    String merchantRefNum;
    String timeStamp;
    String merchantId;
    String customerRef;
    String transactionStatus;
    String customerIpa;
    String amount;
}
