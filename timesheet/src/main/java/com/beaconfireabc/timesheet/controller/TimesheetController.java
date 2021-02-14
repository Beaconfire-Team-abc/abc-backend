package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.Timesheet;
import com.beaconfireabc.timesheet.repository.DefaultRepository;
import com.beaconfireabc.timesheet.repository.TimesheetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
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
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetbyUserID(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(timesheetRepository.findByUserID(id));
    }
//    @GetMapping("/id/{id}")
//    public ResponseEntity<Timesheet> getTimesheetbyID(@PathVariable(value = "id") String id){
//        return ResponseEntity.ok(timesheetRepository.findById(id).orElse(new Timesheet()));
//    }

    @GetMapping("/weekending")
    public ResponseEntity<Timesheet> getTimesheetbyWeekend(@RequestParam String weekend){
        return ResponseEntity.ok((timesheetRepository.findByweekending(weekend).orElse(new Timesheet())));
    }

    @PostMapping("/save")
    public void saveTimesheet(@RequestBody Timesheet timesheet){
//        ObjectMapper mapper = new ObjectMapper();
//        Timesheet newtimesheet = mapper.read
//        Gson gson = new Gson();
//        Timesheet timesheet1 = gson.fromJson(timesheet, Timesheet.class);
        timesheetRepository.save(timesheet);
    }
}
