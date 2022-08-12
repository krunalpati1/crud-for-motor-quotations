package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.FWRequest;
import com.example.motorinsurance.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface FWRequestRepository extends MongoRepository<FWRequest, String> {
    FWRequest findByRequestId(String requestId);

    Object findAllByRequestId(Set<String> singleton);

    void deleteByRequestId(String requestId);
}
