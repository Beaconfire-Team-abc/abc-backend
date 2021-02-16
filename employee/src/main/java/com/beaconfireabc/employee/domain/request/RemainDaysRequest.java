package com.beaconfireabc.employee.domain.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemainDaysRequest {

    private int remainingFloadingDays;

    private int remainingVacationDays;
}