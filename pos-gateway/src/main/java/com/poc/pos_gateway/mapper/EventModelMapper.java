package com.poc.pos_gateway.mapper;

import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.PaymentOrderRequestEvent;
import com.poc.pos_gateway.repositories.entity.PaymentOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EventModelMapper {
    @Mapping(target = "amount", source = "body.amount")
    @Mapping(target = "convenienceFee", source = "body.convenienceFee")
    @Mapping(target = "tip", source = "body.tip")
    @Mapping(target = "validity", source = "body.validity")
    @Mapping(target = "terminalId", source = "body.terminalId")
    PaymentOrder eventModelToPaymentOrder(EventModel<PaymentOrderRequestEvent> eventModel);
}
