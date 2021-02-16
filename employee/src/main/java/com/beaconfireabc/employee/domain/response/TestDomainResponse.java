package com.beaconfireabc.employee.domain.response;

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
public class TestDomainResponse {
    private int id;
    private String name;
    List<Day> days;
}