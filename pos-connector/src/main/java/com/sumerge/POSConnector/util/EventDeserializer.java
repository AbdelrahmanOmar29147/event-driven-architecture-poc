package com.sumerge.POSConnector.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumerge.POSConnector.models.EventModel;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

public class EventDeserializer implements Deserializer<EventModel<Object>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public EventModel<Object> deserialize(String s, byte[] data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.readValue(data, EventModel.class);
        } catch (Exception e) {
            throw new DeserializationException("Failed to deserialize the message", data, false, e);
        }

    }
}

