package com.beaconfireabc.profile.domain;

import com.beaconfireabc.profile.entity.Contact;
import com.beaconfireabc.profile.entity.Person;
import lombok.*;
import org.apache.http.annotation.Contract;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonRequest {

    private String name;

    private String email;

    private String cellphone;

    private String address;

    private RemainDaysRequest remainDays;

    private List<ContactRequest> emergencyContacts;
}
