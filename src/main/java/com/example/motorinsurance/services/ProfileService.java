package com.example.motorinsurance.services;

import com.example.motorinsurance.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    List<Profile> getProfileByRequestId(String requestId);

    String addProfile(Profile profiles);

    Profile updateProfile(String requestId, Profile profile);

    void deleteProfile(String requestId);
}
