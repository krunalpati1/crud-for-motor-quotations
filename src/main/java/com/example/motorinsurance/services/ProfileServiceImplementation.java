package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

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
        profile.setRequestId(requestId);
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

    public void deleteProfile(String requestId) {
        profileRepository.deleteById(requestId);
    }
}
