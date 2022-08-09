package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "supportedInsurer")
@AllArgsConstructor
public class Insurer {
    private String name;
    private String premium;
}
