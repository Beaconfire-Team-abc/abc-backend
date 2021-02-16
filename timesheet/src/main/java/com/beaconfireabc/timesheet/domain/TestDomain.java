package com.beaconfireabc.timesheet.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class TestDomain {
    private int id;
    private String name;
    List<DayResponse> days;
}
