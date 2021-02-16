package com.beaconfireabc.employee.controller;

import com.beaconfireabc.employee.client.ProfileClient;
import com.beaconfireabc.employee.domain.TimeSheet;
import com.beaconfireabc.employee.domain.request.PersonRequest;
import com.beaconfireabc.employee.domain.request.RemainDaysRequest;
import com.beaconfireabc.employee.domain.response.PersonResponse;
import com.beaconfireabc.employee.domain.response.RemainDaysResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileClient profileClient;

    @GetMapping("/{userId}")
    public PersonResponse getProfile(@PathVariable String userId){
        return profileClient.getProfile(userId);
    }

    @PostMapping("/update/{userId}")
    public PersonResponse updateProfile(@RequestBody PersonRequest personRequest, @PathVariable String userId){
        return profileClient.updateProfile(personRequest, userId);
    }

    @PostMapping("/remaindays/update/{userId}")
    public RemainDaysResponse updateRemainDays(@RequestBody RemainDaysRequest remainDaysRequest, @PathVariable String userId){
        return profileClient.updateRemainDays(remainDaysRequest, userId);
    }

/**
    //    @PostMapping("/profile/remiandays/update/{userId}")
    public RemainDaysResponse updateReminDays(TimeSheet oldTimeSheet, TimeSheet newTimeSheet, String userId){
        RemainDaysRequest remainDays = profileClient.getProfile(userId).getPerson().getRemainDays();
        int floatingDaysDiff = oldTimeSheet.getFloatingdays() - newTimeSheet.getFloatingdays();
        int vacationDaysDiff = oldTimeSheet.getVacationdays() - newTimeSheet.getVacationdays();
        remainDays.setRemainingFloadingDays(remainDays.getRemainingFloadingDays() + floatingDaysDiff);
        remainDays.setRemainingVacationDays(remainDays.getRemainingVacationDays() + vacationDaysDiff);
        return profileClient.updateRemainDays(remainDays, userId);
    }
**/
}
