package com.beaconfireabc.employee.controller;

import com.beaconfireabc.employee.client.TimesheetClient;
import com.beaconfireabc.employee.domain.TimeSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    private TimesheetClient timesheetClient;

    // get timesheet list
    @GetMapping("/{userId}")
    public ResponseEntity<List<Object>> getTimeSheets(@PathVariable String userId) {
        return timesheetClient.getTimeSheets(userId);
    }

    // get timesheet by weekending day
    @GetMapping("/{userId}/weekending")
    public ResponseEntity<TimeSheet> getTimeSheetByWeekendingDay(@PathVariable String userId, @RequestParam("weekend") String weekend){
        calculateWeekendingDay(weekend);

        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("weekending",weekend);
        TimeSheet timeSheet = timesheetClient.getTimeSheetByWeekendingDay(parameters, userId);
        if (timeSheet.getWeekending() == null){
            timeSheet = timesheetClient.getDefaultTimeSheet(userId);
            addDateInDefaultTimeSheet(timeSheet, weekend);
        }
        return ResponseEntity.ok(timeSheet);
    }

    // update default timesheet
    @PostMapping("/defaulttimesheet/save")
    public void updateDefaultTimeSheet(@RequestBody TimeSheet timeSheet) {
        timesheetClient.updateDefaultTimeSheet(timeSheet);
    }

    //update timesheet
    @PostMapping("/save")
    public void updateTimeSheet(@RequestBody TimeSheet timeSheet) {
        timesheetClient.updateTimeSheet(timeSheet);
    }

    void addDateInDefaultTimeSheet(TimeSheet timeSheet, String weekend){
        timeSheet.setWeekending(weekend);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate weekendingDate = LocalDate.parse(weekend, dateFormatter);
        for (int i=0;i<7;i++){
            LocalDate then = weekendingDate.minusDays(7-1-i);
            timeSheet.getDays().get(i).setDate(then.format(dateFormatter));
        }
    }

    public void calculateWeekendingDay(String weekend){
        // conetend needed
    }

//    @GetMapping("/{userId}/defaulttimesheet")
//    public ResponseEntity<TimeSheet> getDefaultTimesheet(@PathVariable String userId, @RequestParam("weekending") String weekend){
//        TimeSheet defaultTimeSheet = timesheetClient.getDefaultTimeSheet(userId);
//        addDateInDefaultTimeSheet(defaultTimeSheet, weekend);
//        return ResponseEntity.ok(defaultTimeSheet);
//    }

}
