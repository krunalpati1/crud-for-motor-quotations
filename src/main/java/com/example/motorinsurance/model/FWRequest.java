package com.example.motorinsurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "FWRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FWRequest {

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

