package com.beaconfireabc.timesheet.controller;

import com.beaconfireabc.timesheet.domain.DayResponse;
import com.beaconfireabc.timesheet.domain.TestDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    List<TestDomain> testList = new ArrayList<>();

    TimesheetController(){
        List<DayResponse> list = new ArrayList<>();
        list.add(new DayResponse(1,"Monday"));
        list.add(new DayResponse(2,"Tuesday"));
        testList.add(new TestDomain(1, "David", list));
        testList.add(new TestDomain(2, "Xuan",list));
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from timesheet");
    }

//    @GetMapping("/test/{id}")
//    public ResponseEntity<String> getTestDomain(@PathVariable String id, @RequestParam("weekend") String weekend){
//        System.out.println(id);
//        System.out.println(weekend);
//        TestDomain td = new TestDomain();
//        for (TestDomain t: testList){
//            if (Integer.parseInt(id) == t.getId()){
//                td = t;
//            }
//        }
//        return ResponseEntity.ok("td");
//    }

    @GetMapping("/test")
    public ResponseEntity<String> getTestDomain(@RequestParam("weekending") String weekend){
        System.out.println(weekend);
        return ResponseEntity.ok("td");
    }

    @GetMapping("/tests")
    public ResponseEntity<List<TestDomain>> getTestDomains(){
        return new ResponseEntity<>(testList, HttpStatus.OK);
    }

    @PostMapping("/post/test")
    public void postTest(@RequestBody TestDomain testDomain){
        System.out.println(testDomain.toString());
    }

}
