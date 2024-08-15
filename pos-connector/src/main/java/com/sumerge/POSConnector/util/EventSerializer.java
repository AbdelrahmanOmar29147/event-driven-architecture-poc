package com.sumerge.POSConnector.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumerge.POSConnector.models.EventModel;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;


public class EventSerializer implements Serializer<EventModel<Object>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, EventModel<Object> event) {
        try {
            return objectMapper.writeValueAsBytes(event);
        } catch (Exception e) {
            throw new SerializationException();
        }
    }
}

