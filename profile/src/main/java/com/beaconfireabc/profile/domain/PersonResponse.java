package com.beaconfireabc.profile.domain;

import com.beaconfireabc.profile.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse {

    private ServiceStatus serviceStatus;

    private PersonRequest person;
}
