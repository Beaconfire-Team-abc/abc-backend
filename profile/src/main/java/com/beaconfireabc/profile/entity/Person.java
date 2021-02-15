package com.beaconfireabc.profile.entity;

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
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "cell_phone")
    private String cellphone;

    @Column(name = "remaining_floading_days")
    private int remainingFloadingDays;

    @Column(name = "remaining_vacation_days")
    private int remainingVacationDays;

    @Column(name = "alternate_phone")
    private String alternatePhone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ssn")
    private String SSN;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "user_id")
    private int userId;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "person")
    private List<Contact> contacts = new ArrayList<>();

    @OneToOne(mappedBy = "person")
    private Address address;


}

