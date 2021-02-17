package com.beaconfireabc.timesheet.domain;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class DayResponse {
    int id;
    String name;
}
