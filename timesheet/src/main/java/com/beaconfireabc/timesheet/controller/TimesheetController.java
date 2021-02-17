package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.TestDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/test")
    public ResponseEntity<String> getTestDomain(@RequestParam("weekend") String weekend){
        System.out.println(weekend);
        return ResponseEntity.ok("td");
    }

    @PostMapping("/post/test")
    public void postTest(@RequestBody TestDomain testDomain){
        System.out.println(testDomain.toString());
    }

    // main
    @GetMapping("/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetByUserID(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(timesheetRepository.findByUserID(id));
    }

    @GetMapping("/{id}/weekending")
    public ResponseEntity<Timesheet> getTimesheetByWeekendingAndUserID(@RequestParam String weekending, @PathVariable(value = "id") Integer id){
        System.out.println();
        return ResponseEntity.ok((timesheetRepository.findByUserIDAndWeekendingIgnoreCase(id,weekending).orElse(new Timesheet())));
    }

    @PostMapping("/save")
    public void saveTimesheet(@RequestBody Timesheet timesheet){
        timesheetRepository.save(timesheet);
    }
}
