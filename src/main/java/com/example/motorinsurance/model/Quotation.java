package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Document(collection = "quotation")
@CompoundIndex(def = "{'vertical': 1, 'vehicleMake': 1, 'vehicleModel': 1}", unique = true)
public class Quotation {

    private String id;

    private String vertical;

    private String vehicleMake;

    private String vehicleModel;

    private ArrayList<Insurer> supportedInsurers;
}

