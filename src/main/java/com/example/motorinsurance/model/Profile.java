package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

//@Document(collection = "#{ProfileServiceImplementation.getCollectionName()}")
@Data
@Document(collection = "profile")
@AllArgsConstructor
public class Profile {

    private String id;

    @NotBlank(message = "Vertical is mandatory")
    private String vertical;

    @NotBlank(message = "Vehicle Make is mandatory")
    private String vehicleMake;

    @NotBlank(message = "Vehicle Model is mandatory")
    private String vehicleModel;

    @Indexed(unique = true, background = true)
    private String requestId;
}


