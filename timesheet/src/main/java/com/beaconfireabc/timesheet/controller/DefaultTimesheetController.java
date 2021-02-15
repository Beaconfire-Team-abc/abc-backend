package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.Day;
import com.beaconfireabc.timesheet.domain.DefaultTimesheet;

import com.beaconfireabc.timesheet.repository.DefaultTimesheetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/defaulttimesheet")
public class DefaultTimesheetController {
    @Autowired
    DefaultTimesheetRepository defaultTimesheetRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultTimesheet> getDefaultTimesheetOrCreateByUserID(@PathVariable(value = "id") Integer id){
        List<Day> days = new ArrayList<Day>();
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for(int i = 0; i < 7; i++){
            Day day = Day.builder().name(week[i]).date("").starttime("9:00 A.M.").endtime("6:00 P.M.").isFloatingDay(false).isHoliday(false).isVacation(false).totalhours(8F).build();
            days.add(day);
        }
        DefaultTimesheet defaultTimesheet = DefaultTimesheet.builder().userID(id).weekending("").totalBillingHour(40F).totalCompensatedHour(40F).floatingdays(0)
                .holidays(0).vacationdays(0).approvalStatus("N/A").submissionStatus("Not Started").filepath("").isFileApproved(false).days(days).build();

        // if no defaulttimesheet for this user, create a new default timesheet
        if(!defaultTimesheetRepository.findByUserID(id).isPresent())
            defaultTimesheetRepository.save(defaultTimesheet);

        return ResponseEntity.ok(defaultTimesheetRepository.findByUserID(id).orElse(defaultTimesheet));
    }

    @PostMapping("/save")
    public void postDefaultTimesheet(@RequestBody DefaultTimesheet timesheet){
        defaultTimesheetRepository.save(timesheet);
    }
}
