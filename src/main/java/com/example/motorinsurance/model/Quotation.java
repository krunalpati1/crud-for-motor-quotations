package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "quotation")
@AllArgsConstructor
public class Quotation {
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;
    private ArrayList<Insurer> supportedInsurers;
}
