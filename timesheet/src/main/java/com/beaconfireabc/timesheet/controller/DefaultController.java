package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.DefaultTimesheet;
import com.beaconfireabc.timesheet.domain.Timesheet;
import com.beaconfireabc.timesheet.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/defaulttimesheet")
public class DefaultController {
    @Autowired
    DefaultRepository defaultRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<DefaultTimesheet> getTimesheetbyUserID(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(defaultRepository.findByUserID(id).orElse(new DefaultTimesheet()));
    }

    @PostMapping("/save")
    public void postTimesheet(@RequestBody DefaultTimesheet timesheet){
        defaultRepository.save(timesheet);
    }
}
