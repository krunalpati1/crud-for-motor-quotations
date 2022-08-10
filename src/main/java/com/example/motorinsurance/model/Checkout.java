package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "checkout")
@AllArgsConstructor
public class Checkout {
    @Id
    private String checkoutId;
    private String requestId;
    private String name;
    private String email;
    private String phone;
    private String insurer;
}
