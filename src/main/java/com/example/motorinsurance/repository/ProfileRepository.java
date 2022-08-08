package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}
