package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.Timesheet;

import com.beaconfireabc.timesheet.repository.TimesheetRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {
    @Autowired
    TimesheetRepository timesheetRepository;


    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from timesheet");
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetByUserID(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(timesheetRepository.findByUserIDOrderByWeekendingDesc(id));
    }


    @GetMapping("/{id}/weekending")
    public ResponseEntity<Timesheet> getTimesheetByWeekendAndUserID(@RequestParam String weekend, @PathVariable(value = "id") Integer id){

        return ResponseEntity.ok((timesheetRepository.findByUserIDAndWeekendingIgnoreCase(id,weekend).orElse(new Timesheet())));
    }

    @PostMapping("/save")
    public void saveTimesheet(@RequestBody Timesheet timesheet){

        timesheetRepository.save(timesheet);
    }
}
