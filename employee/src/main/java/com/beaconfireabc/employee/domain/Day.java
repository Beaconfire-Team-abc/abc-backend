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
    private String starttime;
    private String endtime;
    private Boolean isFloatingDay;
    private Boolean isVacation;
    private Boolean isHoliday;
    private Float totalhours;
}
