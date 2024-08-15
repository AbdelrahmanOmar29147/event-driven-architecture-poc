package com.poc.pos_gateway.repositories.repository;

import com.poc.pos_gateway.repositories.entity.PaymentOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentOrderRepository extends MongoRepository<PaymentOrder, String> {
    Optional<PaymentOrder> findByMessageId(String messageId);
}
