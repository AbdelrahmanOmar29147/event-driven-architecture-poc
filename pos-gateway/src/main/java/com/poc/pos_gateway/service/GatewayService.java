package com.poc.pos_gateway.service;

import com.poc.pos_gateway.common.Direction;
import com.poc.pos_gateway.mapper.EventModelMapper;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentOrderRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.request.PaymentRefundRequestEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentOrderResponseEvent;
import com.poc.pos_gateway.model.dto.kafka.response.PaymentRefundResponseEvent;
import com.poc.pos_gateway.repositories.entity.PaymentOrder;
import com.poc.pos_gateway.repositories.entity.PaymentRefund;
import com.poc.pos_gateway.repositories.repository.PaymentOrderRepository;
import com.poc.pos_gateway.repositories.repository.PaymentRefundRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayService {

    private final PaymentOrderRepository paymentOrderRepository;

    private final PaymentRefundRepository paymentRefundRepository;

    private final EventModelMapper eventModelMapper;

    public void savePaymentOrderRequestEvent(EventModel<PaymentOrderRequestEvent> eventModel) {
        Optional<PaymentOrder> existingPaymentOrder = paymentOrderRepository.findByMessageIdAndDirection(eventModel.getMessageId(), Direction.REQUEST);

        if (existingPaymentOrder.isPresent()) {
            log.info("PaymentOrder with messageId " + eventModel.getMessageId() + " already exists.");
        } else {
            PaymentOrder paymentOrder = eventModelMapper.eventModelToPaymentOrderRequest(eventModel);
            paymentOrder.setDirection(Direction.REQUEST);
            paymentOrderRepository.save(paymentOrder);
            log.info("Saved new PaymentOrder with messageId " + eventModel.getMessageId());
        }
    }

    public void savePaymentOrderResponseEvent(EventModel<PaymentOrderResponseEvent> eventModel) {
        Optional<PaymentOrder> existingPaymentOrder = paymentOrderRepository.findByMessageIdAndDirection(eventModel.getMessageId(), Direction.RESPONSE);

        if (existingPaymentOrder.isPresent()) {
            log.info("PaymentOrder with messageId " + eventModel.getMessageId() + " already exists.");
        } else {
            PaymentOrder paymentOrder = eventModelMapper.eventModelToPaymentOrderResponse(eventModel);
            paymentOrder.setDirection(Direction.RESPONSE);
            paymentOrderRepository.save(paymentOrder);
            log.info("Saved new PaymentOrder with messageId " + eventModel.getMessageId());
        }
    }

    public void savePaymentRefundRequestEvent(EventModel<PaymentRefundRequestEvent> eventModel) {
        Optional<PaymentRefund> existingPaymentRefund = paymentRefundRepository.findByRequestIdAndDirection(eventModel.getMessageId(), Direction.REQUEST);

        if (existingPaymentRefund.isPresent()) {
            log.info("PaymentOrder with messageId " + eventModel.getMessageId() + " already exists.");
        } else {
            PaymentRefund paymentRefund = eventModelMapper.eventModelToPaymentRefundRequest(eventModel);
            paymentRefund.setDirection(Direction.REQUEST);
            paymentRefundRepository.save(paymentRefund);
            log.info("Saved new PaymentOrder with messageId " + eventModel.getMessageId());
        }
    }

    public void savePaymentRefundResponseEvent(EventModel<PaymentRefundResponseEvent> eventModel) {
        Optional<PaymentRefund> existingPaymentRefund = paymentRefundRepository.findByRequestIdAndDirection(eventModel.getMessageId(), Direction.RESPONSE);

        if (existingPaymentRefund.isPresent()) {
            log.info("PaymentOrder with messageId " + eventModel.getMessageId() + " already exists.");
        } else {
            PaymentRefund paymentRefund = eventModelMapper.eventModelToPaymentRefundResponse(eventModel);
            paymentRefund.setDirection(Direction.RESPONSE);
            paymentRefundRepository.save(paymentRefund);
            log.info("Saved new PaymentOrder with messageId " + eventModel.getMessageId());
        }
    }

}
