package com.beaconfireabc.employee.client;

import com.beaconfireabc.employee.domain.request.PersonRequest;
import com.beaconfireabc.employee.domain.request.RemainDaysRequest;
import com.beaconfireabc.employee.domain.response.PersonResponse;
import com.beaconfireabc.employee.domain.response.RemainDaysResponse;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profile")
public interface ProfileClient {
    @RequestLine("GET")
    @RequestMapping("/profile/message")
    ResponseEntity<String> getMessage();

    //////////////////// breacking line //////////////////////////
    @RequestLine("GET")
    @RequestMapping("/profile/{userId}")
    PersonResponse getProfile(@PathVariable String userId);

    @RequestLine("POST")
    @RequestMapping("/profile/update-person/{userId}")
    public PersonResponse updateProfile(@RequestBody PersonRequest personRequest, @PathVariable String userId);

    @RequestLine("POST")
    @RequestMapping("/profile/update-remain-days/{userId}")
    public RemainDaysResponse updateRemainDays(@RequestBody RemainDaysRequest remainDaysRequest, @PathVariable String userId);

}
