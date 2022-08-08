package com.example.motorinsurance.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supportedInsurer")
public class Insurer {
    private String name;
    private String premium;

    public Insurer(String name, String premium) {
        this.name = name;
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }
}
