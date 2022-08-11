package com.example.motorinsurance.controller;

import com.example.motorinsurance.model.Profile;
import com.example.motorinsurance.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/turtle")
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping("/profile")
    public List<Profile> getAllProfiles() throws Exception {
        return profileService.getAllProfiles();
    }

    @RequestMapping(value = "/profile", params = "requestId")
    public ResponseEntity<?> getProfile(@Valid @RequestParam String requestId) throws Exception {
        try{
            Profile profile = profileService.getProfileByRequestId(requestId);
            if(profile == null) {
                Map<String, String> response = new HashMap<String, String>() {{
                    put("Data", "Profile not found");
                }};
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PostMapping("/profile")
    public ResponseEntity<?> addProfile(@Valid @RequestBody Profile profile) throws Exception {
        try{
            String requestId = profileService.addProfile(profile);
            Map<String, String> response = new HashMap<String, String>() {{
                put("requestId", requestId);
            }};
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PutMapping(value = "/profile", params = "requestId")
    public Profile updateProfile(@RequestBody Profile profile, @RequestParam String requestId){
        return profileService.updateProfile(requestId, profile);
    }

    @DeleteMapping(value = "/profile", params = "requestId")
    public ResponseEntity<?> deleteProfile(@RequestParam String requestId) throws Exception {
        try{
            profileService.deleteProfile(requestId);
            return new ResponseEntity<>("Profile Deleted Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
