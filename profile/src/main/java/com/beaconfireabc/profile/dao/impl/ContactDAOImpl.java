package com.beaconfireabc.profile.dao.impl;

import com.beaconfireabc.profile.dao.AbstractHibernateDAO;
import com.beaconfireabc.profile.dao.ContactDAO;
import com.beaconfireabc.profile.entity.Contact;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDAOImpl extends AbstractHibernateDAO<Contact> implements ContactDAO {
    public ContactDAOImpl() { setClazz(Contact.class); }

    @Override
    public Contact getContactById(int id) {
        return findById(id);
    }

    @Override
    public Contact setContact(Contact contact) {
        return save(contact);
    }
}
