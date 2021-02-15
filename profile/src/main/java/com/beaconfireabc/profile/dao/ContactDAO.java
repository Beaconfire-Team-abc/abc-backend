package com.beaconfireabc.profile.dao;

import com.beaconfireabc.profile.entity.Contact;

public interface ContactDAO {
    Contact getContactById(int id);

    Contact setContact(Contact contact);
}