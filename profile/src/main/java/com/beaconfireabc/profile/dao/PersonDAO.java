package com.beaconfireabc.profile.dao;

import com.beaconfireabc.profile.entity.Person;


public interface PersonDAO {
    Person getPersonByPersonId(int personId);

    Person getPersonByUserId(int userId);

    Person setPerson(Person person);
}