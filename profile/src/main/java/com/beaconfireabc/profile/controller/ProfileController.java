package com.beaconfireabc.profile.controller;

import com.beaconfireabc.profile.config.HibernateConfig;
import com.beaconfireabc.profile.config.HibernateProperty;
import com.beaconfireabc.profile.domain.*;
import com.beaconfireabc.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;

    @Autowired
    public void setProfileService(ProfileService profileService){this.profileService = profileService;}

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from profile");
    }

    @GetMapping(value="/{userId}")
    public PersonResponse getOrCreateProfile(@PathVariable String userId) {
        PersonResponse personResponse = new PersonResponse();
        PersonRequest responsePerson = this.profileService.getProfileByUserId(Integer.parseInt(userId));
        if (responsePerson != null) {
            personResponse.setPerson(responsePerson);
            preparePersonResponse(personResponse, true, "");
        } else {
            preparePersonResponse(personResponse, false, "No person found.");
        }

        return personResponse;
    }

    @PostMapping(value="/update-remain-days/{userId}")
    public RemainDaysResponse updateRemainDays(@RequestBody RemainDaysRequest remainDaysRequest, @PathVariable String userId){
        RemainDaysResponse remainDaysResponse = new RemainDaysResponse();
        RemainDaysRequest updateRequestReturn = this.profileService.updateRemainDaysByUserId(Integer.parseInt(userId), remainDaysRequest);
        if(updateRequestReturn != null){
            remainDaysResponse.setRemainDays(updateRequestReturn);
            prepareRemainDaysResponse(remainDaysResponse, true, "");
        }
        else{
            prepareRemainDaysResponse(remainDaysResponse, false, "Update remaining days fail");
        }
        return remainDaysResponse;
    }


    @PostMapping(value="/update-person/{userId}")
    public PersonResponse updateProfile(@RequestBody PersonRequest personRequest, @PathVariable String userId) {
        PersonResponse personResponse = new PersonResponse();
        PersonRequest responsePerson = this.profileService.updateProfileByUserId(Integer.parseInt(userId), personRequest);
        if (responsePerson != null) {
            personResponse.setPerson(responsePerson);
            preparePersonResponse(personResponse, true, "");
        } else {
            preparePersonResponse(personResponse, false, "Update person failure.");
        }

        return personResponse;

    }

    private void preparePersonResponse(PersonResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

    private void prepareRemainDaysResponse(RemainDaysResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }


}
