package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuotationRepository extends MongoRepository<Quotation, String> {
    List<Quotation> findAllByVertical();
}
