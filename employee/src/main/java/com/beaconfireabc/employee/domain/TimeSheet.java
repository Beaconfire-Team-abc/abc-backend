package com.beaconfireabc.employee.domain;

import com.beaconfireabc.employee.domain.Day;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class TimeSheet {
    private String id;
    private Integer userID;
    private String weekending;
    private List<Day> days;
    private Float totalBillingHour;
    private Float totalCompensatedHour;
    private String approvalStatus;
    private String submissionStatus;
    private Integer numOfFloatingDays;
    private Integer numOfVacationDays;
    private Integer numOfHolidays;
    private String filePath;
    private Boolean isFileApproved;

}
