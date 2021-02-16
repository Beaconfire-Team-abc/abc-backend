package com.beaconfireabc.employee.domain.response;

import com.beaconfireabc.employee.domain.ServiceStatus;
import com.beaconfireabc.employee.domain.request.PersonRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class PersonResponse {

    private PersonRequest person;

    private ServiceStatus serviceStatus;
}
