package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.CurrentQuotation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrentQuotationRepository extends MongoRepository<CurrentQuotation, String> {
    String deleteByRequestId(String requestId);
}
