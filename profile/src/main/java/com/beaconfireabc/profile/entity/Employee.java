package com.beaconfireabc.profile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "car")
    private String car;

    @Column(name = "visa_start_date")
    private String visaStartDate;

    @Column(name = "visa_end_date")
    private String visaEndDate;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column(name = "driver_license_expiration_date")
    private String driverLicenseExpirationDate;

}