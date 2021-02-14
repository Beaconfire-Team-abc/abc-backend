package com.beaconfireabc.timesheet.repository;

import com.beaconfireabc.timesheet.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {
    List<Timesheet> findByUserID(Integer userID);


    Optional<Timesheet> findByweekending(String weekending);

//    Optional<Object> findById(Integer id);

}



