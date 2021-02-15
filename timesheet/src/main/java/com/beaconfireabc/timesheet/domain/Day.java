package com.beaconfireabc.timesheet.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
