package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyVehicle.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	

}
