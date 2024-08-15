package com.poc.pos_gateway.service;

import com.poc.pos_gateway.mapper.EventModelMapper;
import com.poc.pos_gateway.model.dto.kafka.EventModel;
import com.poc.pos_gateway.model.dto.kafka.PaymentOrderRequestEvent;
import com.poc.pos_gateway.repositories.entity.PaymentOrder;
import com.poc.pos_gateway.repositories.repository.PaymentOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayService {

    private final PaymentOrderRepository paymentOrderRepository;

    private final EventModelMapper eventModelMapper;

    public void processAndSaveEvent(EventModel<PaymentOrderRequestEvent> eventModel) {
        Optional<PaymentOrder> existingPaymentOrder = paymentOrderRepository.findByMessageId(eventModel.getMessageId());

        if (existingPaymentOrder.isPresent()) {
            log.info("PaymentOrder with messageId " + eventModel.getMessageId() + " already exists.");
        } else {
            PaymentOrder paymentOrder = eventModelMapper.eventModelToPaymentOrder(eventModel);
            paymentOrderRepository.save(paymentOrder);
            log.info("Saved new PaymentOrder with messageId " + eventModel.getMessageId());
        }
    }

}
