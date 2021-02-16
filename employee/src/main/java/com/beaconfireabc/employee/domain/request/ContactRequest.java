package com.beaconfireabc.employee.domain.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactRequest {

    private String name;

    private String phone;

    private boolean isEmergencyContact;


}
