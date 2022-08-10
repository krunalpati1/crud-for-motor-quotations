package com.example.motorinsurance.services;

import com.example.motorinsurance.model.CurrentQuotation;
import com.example.motorinsurance.model.Insurer;
import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.model.Quotation;
import com.example.motorinsurance.repository.CurrentQuotationRepository;
import com.example.motorinsurance.repository.ProfileRepository;
import com.example.motorinsurance.repository.QuotationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class QuotationServiceImplementation implements QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private CurrentQuotationRepository currentQuotationRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    @Override
    public List<Quotation> getQuotationByRequestId(String requestId) {
        return (List<Quotation>) quotationRepository.findAllById(Collections.singleton(requestId));
    }

    @Override
    public void addQuotation(Quotation quotation) {
        quotationRepository.save(quotation);
    }

    @Override
    public List<Quotation> updateQuotation(String requestId, Quotation quotation) {
        List<Quotation> quotationList = (List<Quotation>) quotationRepository.findAllById(Collections.singleton(requestId));

        quotationList.forEach(quotation1 -> {
            if(Objects.nonNull(quotation1.getVertical()) && !"".equalsIgnoreCase(quotation.getVertical())){
                quotation1.setVertical(quotation.getVertical());
            }

            if(Objects.nonNull(quotation1.getVehicleMake())&&!"".equalsIgnoreCase(quotation.getVehicleMake())){
                quotation1.setVehicleMake(quotation.getVehicleMake());
            }

            if (Objects.nonNull(quotation1.getVehicleModel())&&!"".equalsIgnoreCase(quotation.getVehicleModel())){
                quotation1.setVehicleModel(quotation.getVehicleModel());
            }
            quotationRepository.save(quotation1);
        });

        return quotationList;
    }

    public void deleteQuotation(String requestId) {
        quotationRepository.deleteById(requestId);
    }

    @Override
    public ArrayList<Insurer> getAllPremiums(String requestId) {
        Profile profile = profileRepository.findByRequestId(requestId);
//        List<Profile> allProfiles = (List<Profile>) profileRepository.findAllById(Collections.singleton(requestId));
//        for(Profile profile : allProfiles){
            String vertical = profile.getVertical();
            String vehicleMake = profile.getVehicleMake();
            String vehicleModel = profile.getVehicleModel();
//        }

        List<Quotation> allQuotationsByVehicleMake = quotationRepository.findAllByVehicleMakeAndVehicleModel(vehicleMake, vehicleModel);


        ArrayList<Insurer> allPremiumsList = new ArrayList<>();
        for(Quotation quotation : allQuotationsByVehicleMake){
            allPremiumsList.addAll(quotation.getSupportedInsurers());
            CurrentQuotation currentQuotation = new CurrentQuotation(requestId, quotation.getSupportedInsurers());
            currentQuotationRepository.save(currentQuotation);
        }
        return allPremiumsList;
    }
}
