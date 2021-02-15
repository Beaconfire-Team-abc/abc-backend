package com.beaconfireabc.timesheet.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "DefaultTimesheet")
public class DefaultTimesheet {
    @Id
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
