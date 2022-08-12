package com.example.motorinsurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "TWResponse")
@AllArgsConstructor
@NoArgsConstructor
public class CurrentQuotation {

    private String requestId;

    private ArrayList<Insurer> supportedInsurers;
}
