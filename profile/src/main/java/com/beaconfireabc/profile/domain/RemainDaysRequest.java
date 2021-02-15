package com.beaconfireabc.profile.domain;


import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemainDaysRequest {

    private int remainingFloadingDays;

    private int remainingVacationDays;
}
