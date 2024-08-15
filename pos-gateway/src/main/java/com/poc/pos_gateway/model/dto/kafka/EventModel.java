package com.poc.pos_gateway.model.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModel<T> {
    private String messageId;
    private String merchantRefNum;
//    private LocalDateTime timeStamp;
    private T body;
}
