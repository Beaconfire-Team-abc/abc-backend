package com.beaconfireabc.profile.dao.impl;

import com.beaconfireabc.profile.dao.AbstractHibernateDAO;
import com.beaconfireabc.profile.dao.AddressDAO;
import com.beaconfireabc.profile.entity.Address;
import org.springframework.stereotype.Repository;


@Repository("addressDao")
public class AddressDAOImpl extends AbstractHibernateDAO<Address> implements AddressDAO {
    public AddressDAOImpl() { setClazz(Address.class); }

    @Override
    public Address getAddressById(int id) {
        return findById(id);
    }

    @Override
    public Address setAddress(Address address) {
        return save(address);
    }
}
