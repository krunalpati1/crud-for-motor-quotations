package com.example.motorinsurance.repository;

import com.example.motorinsurance.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface QuotationRepository extends MongoRepository<Quotation, String> {
    List<Quotation> findAllByVertical(String vertical);

    List<Quotation> findAllByVehicleMakeAndVehicleModel(String vehicleMake, String vehicleModel);
}
