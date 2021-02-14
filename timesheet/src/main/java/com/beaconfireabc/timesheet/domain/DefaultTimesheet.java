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
//@QueryEntity
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
    private Integer floatingdays;
    private Integer vacationdays;
    private Integer holidays;
    private String filepath;
    private Boolean isFileApproved;

}
