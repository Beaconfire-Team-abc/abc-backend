package com.beaconfireabc.employee.client;

import com.beaconfireabc.employee.domain.TimeSheet;
import com.beaconfireabc.employee.domain.response.TestDomainResponse;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@FeignClient(name = "timesheet")
public interface TimesheetClient {
    @RequestLine("GET")
    @RequestMapping("/timesheet/message")
    ResponseEntity<String> getMessage();

    @RequestLine("GET")
    @RequestMapping("/timesheet/test?{parameters}")
    ResponseEntity<String> getTestDomain(@SpringQueryMap Map<String, String> parameters);

    @RequestLine("GET")
    @RequestMapping("/timesheet/tests")
    ResponseEntity<List<Object>> getTests();

////////////////////////////// breaking line //////////////////////

    // get timesheet list
    @RequestLine("GET")
    @RequestMapping("/timesheet/{userId}")
    ResponseEntity<List<Object>> getTimeSheets(@PathVariable String userId);

    // get timesheet by weekendingday
    @RequestLine("GET")
    @RequestMapping("/timesheet/{userId}/weekending?{parameters}")
    TimeSheet getTimeSheetByWeekendingDay(@SpringQueryMap Map<String, String> parameters, @PathVariable String userId);

    // post timesheet
    @RequestLine("POST")
    @RequestMapping("/timesheet/save")
    void updateTimeSheet(@RequestBody TimeSheet timeSheet);

    // get default timesheet
    @RequestLine("GET")
    @RequestMapping("/timesheet/default/{userId}")
    TimeSheet getDefaultTimeSheet(@PathVariable String userId);

    // post default timesheet
    @RequestLine("POST")
    @RequestMapping("/timesheet/default/save")
    void updateDefaultTimeSheet(@RequestBody TimeSheet timeSheet);

    // get timesheet
    // need to be implemented
    @RequestLine("GET")
    @RequestMapping("/timesheet/{userId}/{timeSheetId}")
    Optional<TimeSheet> getTimeSheetByTimeSheetId(@PathVariable String userId, @PathVariable String timeSheetId);


}
