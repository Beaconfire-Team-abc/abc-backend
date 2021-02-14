package com.beaconfireabc.profile.controller;

import com.beaconfireabc.profile.config.HibernateConfig;
import com.beaconfireabc.profile.config.HibernateProperty;
import com.beaconfireabc.profile.domain.PersonRequest;
import com.beaconfireabc.profile.domain.PersonResponse;
import com.beaconfireabc.profile.domain.RemainDaysRequest;
import com.beaconfireabc.profile.domain.ServiceStatus;
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
    public PersonResponse getProfile(@PathVariable String userId) {

        PersonResponse personResponse = new PersonResponse();
        PersonRequest responsePerson = this.profileService.getProfileByUserId(Integer.parseInt(userId));
        if (responsePerson != null) {
            personResponse.setPerson(responsePerson);
            prepareResponse(personResponse, true, "");
        } else {
            prepareResponse(personResponse, false, "No person found.");
        }

        return personResponse;
    }

    @PostMapping(value="/update-remain-days/{userId}")
    public void updateRemainDays(@RequestBody RemainDaysRequest remainDaysRequest, @PathVariable String userId){
//        this.profileService.updatePersonByUserId(Integer.parseInt(userId), remainDaysRequest);
    }


    @PostMapping(value="/update-person/{userId}")
    public void updateProfile(@RequestBody PersonRequest personRequest, @PathVariable String userId) {
//        this.profileService.updatePersonByUserId(Integer.parseInt(userId), personRequest);
    }

    private void prepareResponse(PersonResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }


}
