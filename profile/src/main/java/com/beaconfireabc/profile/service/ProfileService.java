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
    private final int DEFAULT_REMAIN_VACTIONDAYS = 3;
    private final int  DEFAULT_REMAIN_FLOADINGDAYS = 3;

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
            return setProfileByUserId(id);
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
    public PersonRequest setProfileByUserId(int userId){

        Person newPerson = new Person();

        newPerson.setUserId(userId);
        newPerson.setRemainingFloadingDays(DEFAULT_REMAIN_VACTIONDAYS);
        newPerson.setRemainingVacationDays(DEFAULT_REMAIN_FLOADINGDAYS);
        newPerson = personDAO.setPerson(newPerson);

        Address address = new Address();
        address.setPerson(newPerson);
        addressDAO.setAddress(address);

        Contact newContact1 = new Contact();
        newContact1.setPerson(newPerson);
        newContact1.setEmergency(true);
        contactDAO.setContact(newContact1);

        Contact newContact2 = new Contact();
        newContact2.setPerson(newPerson);
        newContact2.setEmergency(true);
        contactDAO.setContact(newContact2);

        RemainDaysRequest remainDaysRequest = new RemainDaysRequest();
        remainDaysRequest.setRemainingFloadingDays(DEFAULT_REMAIN_FLOADINGDAYS);
        remainDaysRequest.setRemainingVacationDays(DEFAULT_REMAIN_VACTIONDAYS);

        PersonRequest personRequest = new PersonRequest();
        personRequest.setRemainDays(remainDaysRequest);
        List<ContactRequest> contactRequestList = new ArrayList<>();
        contactRequestList.add(new ContactRequest("firstname,lastname", "cellphone",true));
        contactRequestList.add(new ContactRequest("firstname,lastname", "cellphone",true));
        personRequest.setEmergencyContacts(contactRequestList);

        return personRequest;
    }

    @Transactional
    public PersonRequest updateProfileByUserId(int userId, PersonRequest personRequest) {
        Person person = this.personDAO.getPersonByUserId(userId);

        person.setEmail(personRequest.getEmail());
        person.setName(personRequest.getName());
        person.setCellphone(personRequest.getCellphone());

        Address address = addressDAO.getAddressById(person.getAddress().getId());
        address.setAddressLineOne(personRequest.getAddress());
        addressDAO.setAddress(address);

        List<Contact> contacts = person.getContacts();
        List<ContactRequest> newContacts = personRequest.getEmergencyContacts();
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).setPhone(newContacts.get(i).getPhone());
            contacts.get(i).setName(newContacts.get(i).getName());
            contactDAO.setContact(contacts.get(i));
        }

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
