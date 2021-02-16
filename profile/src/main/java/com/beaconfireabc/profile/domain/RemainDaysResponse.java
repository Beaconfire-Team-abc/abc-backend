package com.beaconfireabc.profile.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemainDaysResponse {

    private ServiceStatus serviceStatus;

    private RemainDaysRequest remainDays;
}
