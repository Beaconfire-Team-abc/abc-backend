package com.beaconfireabc.profile.dao.impl;

import com.beaconfireabc.profile.dao.AbstractHibernateDAO;
import com.beaconfireabc.profile.dao.PersonDAO;
import com.beaconfireabc.profile.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository("personDao")
public class PersonDAOImpl extends AbstractHibernateDAO<Person> implements PersonDAO {
    public PersonDAOImpl() { setClazz(Person.class); }

    @Override
    public Person getPersonByPersonId(int personId) {
        return findById(personId);
    }

    @Override
    public Person getPersonByUserId(int userId) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        cq.where(cb.equal(root.get("userId"), userId));
        Person person = session.createQuery(cq).uniqueResult();
        if (person == null) return null;

        person.getContacts().size();
        return person;
    }

    @Override
    public Person setPerson(Person person) {
        return save(person);
    }
}
