package com.sumerge.POSConnector.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModel<T> {
    private String messageId;
    private String merchantRefNum;
//    private LocalDateTime timeStamp;
    private T body;
}
