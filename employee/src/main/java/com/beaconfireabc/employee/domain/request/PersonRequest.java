package com.beaconfireabc.employee.domain.request;


import lombok.*;
import org.apache.http.annotation.Contract;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class PersonRequest {

    private String name;

    private String email;

    private String cellphone;

    private String address;

    private RemainDaysRequest remainDays;

    private List<ContactRequest> emergencyContacts;
}
