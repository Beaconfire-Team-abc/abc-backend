package com.beaconfireabc.employee.controller;

import com.beaconfireabc.employee.client.TimesheetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private TimesheetClient timesheetClient;

    @GetMapping("/timesheetMessage")
    public ResponseEntity<String> getMessageFromTimesheet() {
        return timesheetClient.getMessage();
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from employee");
    }
}
