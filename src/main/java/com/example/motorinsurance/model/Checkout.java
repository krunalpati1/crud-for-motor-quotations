package com.example.motorinsurance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "checkout")
public class Checkout {
    @Id
    private String checkoutId;
    private String requestId;
    private String name;
    private String email;
    private String phone;
    private String insurer;
    private String premium;

    public Checkout(String checkoutId, String requestId, String name, String email, String phone, String insurer, String premium) {
        this.checkoutId = checkoutId;
        this.requestId = requestId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.insurer = insurer;
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
