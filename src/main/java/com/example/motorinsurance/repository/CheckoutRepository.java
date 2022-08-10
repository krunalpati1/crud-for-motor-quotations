package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckoutRepository extends MongoRepository<Checkout, String> {
    List<Object> findByRequestId(String requestId);

    String deleteByRequestId(String requestId);
}
