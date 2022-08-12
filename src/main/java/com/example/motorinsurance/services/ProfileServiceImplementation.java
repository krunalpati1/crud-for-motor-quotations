package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.repository.CheckoutRepository;
import com.example.motorinsurance.repository.CurrentQuotationRepository;
//import com.example.motorinsurance.repository.EventDataRepository;
import com.example.motorinsurance.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CurrentQuotationRepository currentQuotationRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

//    @Autowired
//    private EventDataRepository eventDataRepository;

//    @Autowired
//    private EventDataService eventDataService;

//    private String collectionName = "TWCollection";

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileByRequestId(String requestId) {
        return profileRepository.findByRequestId(requestId);
    }

    @Override
    public String addProfile(Profile profile) {
        Random rd = new Random();
        String requestId = String.valueOf(Math.abs(rd.nextLong()));

        while(profileRepository.findByRequestId(requestId) != null){
            requestId = String.valueOf(Math.abs(rd.nextLong()));
        }
        profile.setRequestId(requestId);

//        String vertical = profile.getVertical();
//        if(vertical.equalsIgnoreCase("TW")){
//            profileRepository.setCollectionName("TWCollection");
//        } else if(vertical.equalsIgnoreCase("FW")){
//            profileRepository.setCollectionName("FWCollection");
//        }

        profileRepository.save(profile);
        return requestId;
    }

    @Override
    public Profile updateProfile(String requestId, Profile profile) {
        Profile profile1 = profileRepository.findByRequestId(requestId);

        if(Objects.nonNull(profile1.getVertical()) && !"".equalsIgnoreCase(profile.getVertical())){
            profile1.setVertical(profile.getVertical());
        }

        if(Objects.nonNull(profile1.getVehicleMake())&&!"".equalsIgnoreCase(profile.getVehicleMake())){
            profile1.setVehicleMake(profile.getVehicleMake());
        }

        if (Objects.nonNull(profile1.getVehicleModel())&&!"".equalsIgnoreCase(profile.getVehicleModel())){
            profile1.setVehicleModel(profile.getVehicleModel());
        }
        profileRepository.save(profile1);
        return profile1;
    }

    public String deleteProfile(String requestId) {
        currentQuotationRepository.deleteByRequestId(requestId);
        checkoutRepository.deleteByRequestId(requestId);
        profileRepository.deleteByRequestId(requestId);
        return "Profile deleted successfully!";
    }

//    public String getCollectionName(){
//        return collectionName;
//    }
//
//    public void setCollectionName(String collectionName){
//        ProfileServiceImplementation.collectionName = collectionName;
//    }
}
