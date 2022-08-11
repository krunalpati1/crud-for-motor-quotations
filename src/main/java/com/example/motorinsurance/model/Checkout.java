package com.example.motorinsurance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;

@Data
@Document(collection = "checkout")
@AllArgsConstructor
public class Checkout {
    @Id
    private String checkoutId;

    @NotBlank(message = "Request Id is mandatory")
    @Indexed(unique = true)
    private String requestId;

    @NotBlank(message = "Customer Name is mandatory")
    private String name;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", flags = Pattern.Flag.UNICODE_CASE)
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", flags = Pattern.Flag.UNICODE_CASE)
    @NotBlank(message = "Customer Phone is mandatory")
    private String phone;

    @NotBlank(message = "Insurer is mandatory")
    private String insurer;
}
