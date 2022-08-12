package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

//public interface ProfileRepository extends MongoRepository<Profile, String>, ProfileRepositoryCustom {
public interface ProfileRepository extends MongoRepository<Profile, String> {
    Profile findByRequestId(String requestId);

    Object findAllByRequestId(Set<String> singleton);

    void deleteByRequestId(String requestId);

//    String getCollectionName();
//
//    void setCollectionName(String collectionName);
}
