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
    private String starttime;
    private String endtime;
    private Boolean isFloatingDay;
    private Boolean isVacation;
    private Boolean isHoliday;
    private Float totalhours;
}
