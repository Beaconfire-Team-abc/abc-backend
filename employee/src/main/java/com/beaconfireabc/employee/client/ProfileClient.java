package com.beaconfireabc.employee.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profile")
public interface ProfileClient {
    @RequestLine("GET")
    @RequestMapping("/profile/message")
    ResponseEntity<String> getMessage();
}
