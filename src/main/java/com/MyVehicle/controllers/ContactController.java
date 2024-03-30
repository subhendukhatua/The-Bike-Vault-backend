package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.Contact;
import com.MyVehicle.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public String getContact() {
		return "contact1";
	}
	
	@GetMapping("/getAllContacts")
	public List<Contact>getAllContacts(){
		List<Contact> allContacts = contactService.getAllContacts();
		return allContacts;
		
	}
	
	@GetMapping("/getContactById/{id}")
	public Contact getContactById(@PathVariable int id) {
		Contact contactById = contactService.getContactById(id);
		return contactById;
	}
	
	@PostMapping("/createContact")
	public Contact createContact(@RequestBody Contact contact) {
		Contact createContact = contactService.createContact(contact);
		return createContact;
	}
	
	@PutMapping("/updateContact/{id}")
	public Contact updateContact(@RequestBody Contact contact,@PathVariable int id) {
		Contact updateContact = contactService.updateContact(contact, id);
		return updateContact;
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public String deleteContactById(@PathVariable int id) {
		contactService.deleteById(id);
		return ("contact deleted which id is "+ id);
	}
	
	public String deleteAllContact() {
		contactService.deleteAllContact();
		return "All contacts are deleted";
	}

}
