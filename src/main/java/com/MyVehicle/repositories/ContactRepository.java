package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.MyVehicle.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	Contact findById(int id);
}
