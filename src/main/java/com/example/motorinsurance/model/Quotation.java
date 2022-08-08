package com.example.motorinsurance.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "quotation")
public class Quotation {
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;

    private ArrayList<Insurer> supportedInsurers;

    public Quotation(String id, String vertical, String vehicleMake, String vehicleModel, ArrayList<Insurer> supportedInsurers) {
        this.id = id;
        this.vertical = vertical;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.supportedInsurers = supportedInsurers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public ArrayList<Insurer> getSupportedInsurers() {
        return supportedInsurers;
    }

    public void setSupportedInsurers(ArrayList<Insurer> supportedInsurers) {
        this.supportedInsurers = supportedInsurers;
    }
}
