package com.sumerge.POSConnector.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WebsocketMessage
{
    String operationId;
    String messageId;
    String merchantRefNum;
    String timeStamp;
    Object data;
}
