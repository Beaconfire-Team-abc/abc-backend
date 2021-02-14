package com.beaconfireabc.timesheet.repository;

import com.beaconfireabc.timesheet.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {
    List<Timesheet> findByUserID(Integer userID);

    @Query("{'Weekending' : ?0}")
    Optional<Timesheet> findByWeekending(String Weekending);
}



