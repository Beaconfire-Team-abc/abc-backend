package com.beaconfireabc.profile.dao;

import com.beaconfireabc.profile.entity.Address;

public interface AddressDAO {
    Address getAddressById(int id);

    Address setAddress(Address address);
}