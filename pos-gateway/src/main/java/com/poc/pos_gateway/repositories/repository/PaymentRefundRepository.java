package com.poc.pos_gateway.repositories.repository;

import com.poc.pos_gateway.common.Direction;
import com.poc.pos_gateway.repositories.entity.PaymentRefund;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRefundRepository extends MongoRepository<PaymentRefund, String> {
    Optional<PaymentRefund> findByRequestIdAndDirection(@NotBlank String messageId, @NotBlank Direction direction);
}
