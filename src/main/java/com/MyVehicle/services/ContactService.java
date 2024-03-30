package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Contact;
import com.MyVehicle.repositories.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//create new contact
	public Contact createContact(Contact contact) {
		Contact newContact = contactRepository.save(contact);
		return newContact;
	}
	
	//get all contact
	public List<Contact> getAllContacts(){
		List<Contact> allContacts = contactRepository.findAll();
		return allContacts;
	}
	
	//get contact by id
	public Contact getContactById(int id) {
		Contact findById = contactRepository.findById(id);
		return findById;
	}
	
	//update a contact
	public Contact updateContact(Contact contact,int id) {
		contact.setId(contact.getId());
		Contact updatedContact = contactRepository.save(contact);
		return updatedContact;
	}
	
	//delete contact by id
	public void deleteById(int id) {
		contactRepository.deleteById(id);
	}
	
	//delete all contact
	public void deleteAllContact() {
		contactRepository.deleteAll();
	}
	

}
