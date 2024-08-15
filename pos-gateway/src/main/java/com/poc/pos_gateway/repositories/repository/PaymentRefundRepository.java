package com.poc.pos_gateway.repositories.repository;

import com.poc.pos_gateway.repositories.entity.PaymentRefund;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRefundRepository extends MongoRepository<PaymentRefund, String> {
}
