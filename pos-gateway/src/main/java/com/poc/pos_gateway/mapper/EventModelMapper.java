package com.poc.pos_gateway.mapper;

import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentOrderRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentRefundRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentOrderResponseEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentRefundResponseEvent;
import com.poc.pos_gateway.repositories.entity.PaymentOrder;
import com.poc.pos_gateway.repositories.entity.PaymentRefund;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventModelMapper {
    @Mapping(target = "operationId", source = "body.operationId")
    @Mapping(target = "amount", source = "body.data.amount")
    @Mapping(target = "convenienceFee", source = "body.data.convenienceFee")
    @Mapping(target = "tip", source = "body.data.tip")
    @Mapping(target = "validity", source = "body.data.validity")
    @Mapping(target = "terminalId", source = "body.data.terminalId")
    PaymentOrder eventModelToPaymentOrderRequest(EventModel<PaymentOrderRequestEvent> eventModel);

    @Mapping(target = "qrCode", source = "body.data.qrCode")
    PaymentOrder eventModelToPaymentOrderResponse(EventModel<PaymentOrderResponseEvent> eventModel);

    @Mapping(target = "originalMerchantRefNum", source = "body.originalMerchantRefNum")
    @Mapping(target = "amount", source = "body.amount")
    @Mapping(target = "terminalId", source = "body.terminalId")
    PaymentRefund eventModelToPaymentRefundRequest(EventModel<PaymentRefundRequestEvent> eventModel);

    @Mapping(target = "merchantId", source = "body.merchantId")
    @Mapping(target = "amount", source = "body.amount")
    @Mapping(target = "customerRef", source = "body.customerRef")
    @Mapping(target = "transactionStatus", source = "body.transactionStatus")
    @Mapping(target = "customerIpa", source = "body.customerIpa")
    PaymentRefund eventModelToPaymentRefundResponse(EventModel<PaymentRefundResponseEvent> eventModel);
}
