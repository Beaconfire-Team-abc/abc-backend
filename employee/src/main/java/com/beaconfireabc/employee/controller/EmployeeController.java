package com.beaconfireabc.employee.controller;

import com.beaconfireabc.employee.client.ProfileClient;
import com.beaconfireabc.employee.client.TimesheetClient;
import com.beaconfireabc.employee.domain.Day;
import com.beaconfireabc.employee.domain.TimeSheet;
import com.beaconfireabc.employee.domain.request.PersonRequest;
import com.beaconfireabc.employee.domain.request.RemainDaysRequest;
import com.beaconfireabc.employee.domain.response.PersonResponse;
import com.beaconfireabc.employee.domain.response.RemainDaysResponse;
import com.beaconfireabc.employee.domain.response.TestDomainResponse;
import com.beaconfireabc.employee.domain.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private TimesheetClient timesheetClient;

    @Autowired
    private ProfileClient profileClient;

    @GetMapping("/timesheetMessage")
    public ResponseEntity<String> getMessageFromTimesheet() {
        return timesheetClient.getMessage();
    }

    @GetMapping("/profileMessage")
    public ResponseEntity<String> getMessageFromProfile() {
        return profileClient.getMessage();
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from employee");
    }

//    @GetMapping("/timesheet/{userId}")
//    public ResponseEntity<Object> getTest(HttpServletRequest httpServletRequest, @PathVariable String userId, @RequestParam("weekend") String weekend) {
//        System.out.println(weekend);
//        return timesheetClient.getTestDomain(userId, weekend);
//    }

    @GetMapping("/test")
    ResponseEntity<String> getTestDomain(@RequestParam("weekend") String weekend){
        System.out.println(weekend);
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("weekend",weekend);
        return timesheetClient.getTestDomain(parameters);
    }

    @GetMapping("/tests")
    ResponseEntity<List<Object>> getTests(@RequestParam("weekend") String weekend){
        System.out.println(weekend);
        return timesheetClient.getTests();
    }

    // profile
    @GetMapping("/profile/{userId}")
    public PersonResponse getProfile(@PathVariable String userId){
        return profileClient.getProfile(userId);
    }

    @PostMapping("/profile/update/{userId}")
    public PersonResponse updateProfile(@RequestBody PersonRequest personRequest, @PathVariable String userId){
        return profileClient.updateProfile(personRequest, userId);
    }

//    @PostMapping("/profile/remiandays/update/{userId}")
    public RemainDaysResponse updateReminDays(TimeSheet oldTimeSheet, TimeSheet newTimeSheet, String userId){
        RemainDaysRequest remainDays = profileClient.getProfile(userId).getPerson().getRemainDays();
        int floatingDaysDiff = oldTimeSheet.getFloatingdays() - newTimeSheet.getFloatingdays();
        int vacationDaysDiff = oldTimeSheet.getVacationdays() - newTimeSheet.getVacationdays();
        remainDays.setRemainingFloadingDays(remainDays.getRemainingFloadingDays() + floatingDaysDiff);
        remainDays.setRemainingVacationDays(remainDays.getRemainingVacationDays() + vacationDaysDiff);
        return profileClient.updateRemainDays(remainDays, userId);
    }

/**
    @PostMapping("/timesheet/update")
    public void updateTimeSheet(@RequestBody TimeSheetRequest timeSheet){
        Option<TimeSheetRequest> oldTimeSheet = timesheetClient.findTimeSheetbyTimeSheetId(timeSheet.getTimeSheetId());
        if (oldTimeSheet == null){
            // update remainding floating days algorithm
            timesheetClient.save(timeSheet);
        }else{
            // update remainding floating days algorithm
            timesheetClient.update(timeSheet);
        }
    }
 **/

}
