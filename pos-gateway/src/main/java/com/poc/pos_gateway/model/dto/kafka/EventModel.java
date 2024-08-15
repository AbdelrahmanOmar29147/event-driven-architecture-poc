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
    //timeStamp is supposed to be of a date type with this format YYYY-MM-DD hh:mm:ss.ttt
    private String timeStamp;
    private T body;
}
