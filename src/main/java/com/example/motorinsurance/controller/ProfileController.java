package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Insurer;
import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/turtle")
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping("/profile")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @RequestMapping(value = "/profile", params = "requestId")
    public List<Profile> getProfile(@RequestParam String requestId){
        return profileService.getProfileByRequestId(requestId);
    }

    @PostMapping("/profile")
    public String addProfile(@RequestBody Profile profile){
        profileService.addProfile(profile);
        System.out.println("Profile created!");
        return "Profile created!";
    }

    @PutMapping(value = "/profile", params = "requestId")
    public Profile updateProfile(@RequestBody Profile profile, @RequestParam String requestId){
        return profileService.updateProfile(requestId, profile);
    }

    @DeleteMapping(value = "/profile", params = "requestId")
    public String deleteProfile(@RequestParam String requestId){
        profileService.deleteProfile(requestId);
        System.out.println("Profile Deleted!");
        return "Deleted Successfully";
    }
}
