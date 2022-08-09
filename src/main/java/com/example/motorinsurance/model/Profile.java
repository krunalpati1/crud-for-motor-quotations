package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "#{ProfileServiceImplementation.getCollectionName()}")
@Data
@Document(collection = "profile")
@AllArgsConstructor
public class Profile {

    private String id;

    private String vertical;

    private String vehicleMake;

    private String vehicleModel;

    private String requestId;
}


