package com.beaconfireabc.timesheet.repository;

import com.beaconfireabc.timesheet.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {
    List<Timesheet> findByUserIDOrderByWeekendingDesc(Integer userID);

    Optional<Timesheet> findByUserIDAndWeekendingIgnoreCase(Integer userID, String weekending);

}



