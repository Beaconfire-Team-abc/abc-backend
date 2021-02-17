package com.beaconfireabc.employee.domain.response;
import com.beaconfireabc.employee.domain.Day;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TimeSheetResponse {
    private String id;
    private Integer userID;
    private String Weekending;
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
