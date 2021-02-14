package com.beaconfireabc.profile.service;

import com.beaconfireabc.profile.dao.PersonDAO;
import com.beaconfireabc.profile.domain.ContactRequest;
import com.beaconfireabc.profile.domain.PersonRequest;
import com.beaconfireabc.profile.domain.PersonResponse;
import com.beaconfireabc.profile.domain.RemainDaysRequest;
import com.beaconfireabc.profile.entity.Address;
import com.beaconfireabc.profile.entity.Contact;
import com.beaconfireabc.profile.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;


@Component
public class ProfileService {
    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO){ this.personDAO = personDAO;}

    @Transactional
    public PersonRequest getProfileByUserId(Integer id) {
        Person person = personDAO.getPersonByUserId(id);

        PersonRequest personRequest = new PersonRequest();
        personRequest.setEmail(person.getEmail());
        return personRequest;
    }


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

        //save address
        Address address = new Address();
        address.setAddressLineOne(personRequest.getAddress());
        address.setPerson(newPerson);

        //save contacts
        for(ContactRequest each : personRequest.getEmergencyContacts()){
            Contact newContact = new Contact();
            newContact.setPerson(newPerson);
            newContact.setEmergency(each.isEmergencyContact());
            newContact.setName(each.getName());
            newContact.setPhone(each.getPhone());
        }



        return personRequest;

    }

    @Transactional
    public PersonRequest updateProfileByUserId(int userId, PersonRequest personRequest) {

    }



//
//        // save employee
//        Employee employee = new Employee();
//        VisaStatus visaStatus = visaStatusDAO.getVisaStatusByName(employeeRequest.getVisaStatus().get("visaType"));
//        House house = houseDAO.getHouseById(employeeRequest.getHouseId());
//
//        employee.setTitle(employeeRequest.getTitle());
//        employee.setStartDate(employeeRequest.getStartDate());
//        employee.setEndDate(employeeRequest.getEndDate());
//        employee.setAvatar(employeeRequest.getAvatar());
//        employee.setCar(employeeRequest.getCar());
//        employee.setVisaStartDate(employeeRequest.getVisaStatus().get("visaStartDate"));
//        employee.setVisaEndDate(employeeRequest.getVisaStatus().get("visaEndDate"));
//        employee.setDriverLicense(employeeRequest.getDriverLicense());
//        employee.setDriverLicenseExpirationDate(employeeRequest.getDriverLicenseExpirationDate());
//        employee.setVisaStatus(visaStatus);
//        employee.setHouse(house);
//

//        // save address
//        Address address = new Address();
//        address.setAddressLineOne(addressRequest.getAddressLineOne());
//        address.setAddressLineTwo(addressRequest.getAddressLineTwo());
//        address.setCity(addressRequest.getCity());
//        address.setZipcode(addressRequest.getZipcode());
//        address.setStateName(addressRequest.getStateName());
//        address.setStateAbbr(addressRequest.getStateAbbr());
//
//        // save person
//        Person person = new Person();
//        person.setFirstName(personRequest.getFirstName());
//        person.setLastName(personRequest.getLastName());
//        person.setMiddleName(personRequest.getMiddleName());
//        person.setEmail(personRequest.getEmail());
//        person.setCellphone(personRequest.getCellPhone());
//        person.setAlternatePhone(personRequest.getAlternatePhone());
//        person.setGender(personRequest.getGender());
//        person.setSSN(personRequest.getSsn());
//        person.setDOB(personRequest.getDob());
//        person.setUserId(personRequest.getUserId());
//
//        person = personDAO.setPerson(person);
//
//        address.setPerson(person);
//        address = addressDAO.setAddress(address);
//
//        employee.setPerson(person);
//        employee = employeeDAO.setEmployee(employee);
//
//        applicationWorkflow.setEmployee(employee);
//        applicationWorkflow = applicationWorkflowDAO.setApplicationWorkflow(applicationWorkflow);
//
//        // save personal document
//        for (int i = 0; i < personalDocumentRequests.size(); i++) {
//            PersonalDocumentRequest personalDocumentRequest = personalDocumentRequests.get(i);
//            PersonalDocument personalDocument = new PersonalDocument();
//            personalDocument.setTitle(personalDocumentRequest.getTitle());
//            personalDocument.setPath(personalDocumentRequest.getPath());
//            personalDocument.setCreatedDate(currentDate);
//            personalDocument.setCreateBy(person.getFirstName());
//            personalDocument.setEmployee(employee);
//            personalDocumentDAO.setPersonalDocument(personalDocument);
//        }
//
//        // save contact
//        Contact reference = new Contact();
//        reference.setTitle(contactRequest.getReference().get("title"));
//        reference.setRelationship(contactRequest.getReference().get("relationship"));
//        reference.setReference(true);
//        reference.setPerson(person);
//        contactDAO.setContact(reference);
//
//        Contact emergency = new Contact();
//        emergency.setTitle(contactRequest.getEmergency().get("title"));
//        emergency.setRelationship(contactRequest.getEmergency().get("relationship"));
//        emergency.setEmergency(true);
//        emergency.setPerson(person);
//        contactDAO.setContact(emergency);
//
//        return person.getUserId();
    }

    @Transactional
    public void updateRemainDaysByUserId(int userId, RemainDaysRequest remainDaysRequest) {
//        Person person = this.personDAO.getPersonByUserId(userId);
//        person.setFirstName(personRequest.getFirstName());
//        person.setLastName(personRequest.getLastName());
//        person.setMiddleName(personRequest.getMiddleName());
//        person.setEmail(personRequest.getEmail());
//        person.setCellphone(personRequest.getCellPhone());
//        person.setAlternatePhone(personRequest.getAlternatePhone());
//        person.setGender(personRequest.getGender());
//        person.setSSN(personRequest.getSsn());
//        person.setDOB(personRequest.getDob());
//        personDAO.setPerson(person);
    }


}
