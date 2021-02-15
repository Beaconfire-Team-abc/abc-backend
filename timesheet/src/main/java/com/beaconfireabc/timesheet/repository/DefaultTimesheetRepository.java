package com.beaconfireabc.timesheet.repository;

import com.beaconfireabc.timesheet.domain.DefaultTimesheet;
import com.beaconfireabc.timesheet.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DefaultTimesheetRepository extends MongoRepository<DefaultTimesheet, String> {
    Optional<DefaultTimesheet> findByUserID(Integer userID);
}
