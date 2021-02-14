package com.beaconfireabc.profile.service;

import com.beaconfireabc.profile.dao.AddressDAO;
import com.beaconfireabc.profile.dao.ContactDAO;
import com.beaconfireabc.profile.dao.PersonDAO;
import com.beaconfireabc.profile.domain.ContactRequest;
import com.beaconfireabc.profile.domain.PersonRequest;
import com.beaconfireabc.profile.domain.RemainDaysRequest;
import com.beaconfireabc.profile.entity.Address;
import com.beaconfireabc.profile.entity.Contact;
import com.beaconfireabc.profile.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProfileService {

    private PersonDAO personDAO;
    private AddressDAO addressDAO;
    private ContactDAO contactDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO){ this.personDAO = personDAO;}

    @Autowired
    public void setAddressDAO(AddressDAO addressDAO){this.addressDAO = addressDAO;}

    @Autowired
    public void setContactDAO(ContactDAO contactDAO){this.contactDAO = contactDAO;}

    @Transactional
    public PersonRequest getProfileByUserId(Integer id) {
        Person person = personDAO.getPersonByUserId(id);
        if(person == null){
            return null;
        }
        else{
            PersonRequest personRequest = new PersonRequest();

            RemainDaysRequest remainDays = new RemainDaysRequest();
            remainDays.setRemainingFloadingDays(person.getRemainingFloadingDays());
            remainDays.setRemainingVacationDays(person.getRemainingVacationDays());

            List<ContactRequest> contactRequestList = new ArrayList<>();
            for(Contact contact : person.getContacts()){
                ContactRequest contactRequest = new ContactRequest();
                contactRequest.setName(contact.getName());
                contactRequest.setPhone(contact.getPhone());
                contactRequest.setEmergencyContact(contact.isEmergency());
                contactRequestList.add(contactRequest);
            }

            personRequest.setEmergencyContacts(contactRequestList);
            personRequest.setAddress(person.getAddress().getAddressLineOne());
            personRequest.setName(person.getName());
            personRequest.setEmail(person.getEmail());
            personRequest.setCellphone(person.getCellphone());
            personRequest.setRemainDays(remainDays);
            return personRequest;
        }

    }

    @Transactional
    public  PersonRequest setOrUpdateProfileByUserId(int userId, PersonRequest personRequest){
        Person person = personDAO.getPersonByUserId(userId);
        if(person == null){
            return setProfileByUserId(userId, personRequest);
        }
        else{
            return updateProfileByUserId(userId, personRequest);
        }
    }

    @Transactional
    public PersonRequest setProfileByUserId(int userId, PersonRequest personRequest){
        //save person
        Person newPerson = new Person();
        newPerson.setEmail(personRequest.getEmail());
        newPerson.setName(personRequest.getName());
        newPerson.setCellphone(personRequest.getCellphone());
        newPerson.setUserId(userId);

        newPerson.setRemainingFloadingDays(personRequest.getRemainDays().getRemainingFloadingDays());
        newPerson.setRemainingVacationDays(personRequest.getRemainDays().getRemainingFloadingDays());
        newPerson = personDAO.setPerson(newPerson);

        //save address
        Address address = new Address();
        address.setAddressLineOne(personRequest.getAddress());
        address.setPerson(newPerson);
        addressDAO.setAddress(address);


        //save contacts
        for(ContactRequest each : personRequest.getEmergencyContacts()){
            Contact newContact = new Contact();
            newContact.setPerson(newPerson);
            newContact.setEmergency(each.isEmergencyContact());
            newContact.setName(each.getName());
            newContact.setPhone(each.getPhone());
            contactDAO.setContact(newContact);
        }

        return personRequest;

    }

    @Transactional
    public PersonRequest updateProfileByUserId(int userId, PersonRequest personRequest) {
        Person person = this.personDAO.getPersonByPersonId(userId);
        // update person
        person.setEmail(personRequest.getEmail());
        person.setName(personRequest.getName());
        person.setCellphone(personRequest.getCellphone());


        // update address
        Address address = addressDAO.getAddressById(person.getAddress().getId());
        address.setAddressLineOne(personRequest.getAddress());

        // update emergence contact
        List<Contact> contacts = person.getContacts();
        List<ContactRequest> newContacts = personRequest.getEmergencyContacts();
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).setPhone(newContacts.get(i).getPhone());
            contacts.get(i).setName(newContacts.get(i).getName());
            contactDAO.setContact(contacts.get(i));
        }

        //remainsDaysUnchange
        RemainDaysRequest remainDays = new RemainDaysRequest();
        remainDays.setRemainingFloadingDays(person.getRemainingFloadingDays());
        remainDays.setRemainingVacationDays(person.getRemainingVacationDays());
        personRequest.setRemainDays(remainDays);

        return personRequest;
    }


    @Transactional
    public RemainDaysRequest updateRemainDaysByUserId(int userId, RemainDaysRequest remainDaysRequest) {
        Person person = this.personDAO.getPersonByPersonId(userId);
        person.setRemainingFloadingDays(remainDaysRequest.getRemainingFloadingDays());
        person.setRemainingVacationDays(remainDaysRequest.getRemainingVacationDays());
        Person updatedperson = personDAO.setPerson(person);
        if(updatedperson == null){
            return null;
        }
        return remainDaysRequest;
    }


}
