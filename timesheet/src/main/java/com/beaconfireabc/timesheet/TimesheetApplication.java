package com.beaconfireabc.timesheet;

import com.beaconfireabc.timesheet.domain.Timesheet;
import com.beaconfireabc.timesheet.repository.DefaultRepository;
import com.beaconfireabc.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimesheetApplication implements CommandLineRunner {

    @Autowired
    TimesheetRepository repository;
    @Autowired
    DefaultRepository defaultRepository;

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }
    // commit test

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        defaultRepository.deleteAll();


        System.out.println("Timesheets found with findAll():");
        System.out.println("-------------------------------");
        for (Timesheet timesheet : repository.findAll()) {
            System.out.println(timesheet);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Timesheet found with findByWeekending('02/12/21'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByweekending("02/12/21").orElse(null));

        System.out.println("Timesheets found with findByUserID(1):");
        System.out.println("--------------------------------");
        for (Timesheet timesheet : repository.findByUserID(1)) {
            System.out.println(timesheet);
        }
    }

}
