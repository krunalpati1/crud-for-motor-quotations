package com.example.motorinsurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "current_quotation")
@AllArgsConstructor
public class CurrentQuotation {
    private String requestId;
    private ArrayList<Insurer> supportedInsurers;
}
