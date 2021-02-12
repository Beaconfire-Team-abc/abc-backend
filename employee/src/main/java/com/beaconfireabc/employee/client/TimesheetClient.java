package com.beaconfireabc.employee.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "timesheet")
public interface TimesheetClient {
    @RequestLine("GET")
    @RequestMapping("/timesheet/message")
    ResponseEntity<String> getMessage();
}
