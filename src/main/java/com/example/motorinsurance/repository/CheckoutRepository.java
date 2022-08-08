package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckoutRepository extends MongoRepository<Checkout, String> {
}
