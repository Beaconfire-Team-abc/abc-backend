package com.beaconfireabc.employee.domain;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Day {

    private String name;
    private String date;
    private String startTime;
    private String endTime;
    private Boolean isFloatingDay;
    private Boolean isVacationDay;
    private Boolean isHoliday;
    private Float totalHours;
}
