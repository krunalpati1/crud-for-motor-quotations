package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "supportedInsurer")
@AllArgsConstructor
@NoArgsConstructor
public class Insurer {
    @Id
    private String Id;

    private String name;

    private String premium;
}
