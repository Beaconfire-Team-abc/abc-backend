package com.beaconfireabc.timesheet;

import com.beaconfireabc.timesheet.domain.Timesheet;
import com.beaconfireabc.timesheet.repository.DefaultTimesheetRepository;
import com.beaconfireabc.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimesheetApplication {

//    @Autowired
//    TimesheetRepository repository;
//    @Autowired
//    DefaultTimesheetRepository defaultRepository;

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        repository.deleteAll();
//        defaultRepository.deleteAll();
//
//        repository.save(Timesheet.builder().userID(1).weekending("02/12/21").build());
//        System.out.println("Timesheets found with findAll():");
//        System.out.println("-------------------------------");
//        for (Timesheet timesheet : repository.findAll()) {
//            System.out.println(timesheet);
//        }
//        System.out.println();
//
//
//        System.out.println("Timesheets found with findByUserID(1):");
//        System.out.println("--------------------------------");
//        for (Timesheet timesheet : repository.findByUserID(1)) {
//            System.out.println(timesheet);
//        }
//
//        System.out.println(("Timesheet found with findByUserIDAndWeekending(1,'02/12/21')"));
//        System.out.println("--------------------------------");
//
//        System.out.println(repository.findByUserIDAndWeekendingIgnoreCase(1,"02/12/21").orElse(null));
//
//    }

}
