package com.MyVehicle.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyVehicle.models.Role;
import com.MyVehicle.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User>findByEmail(String email);
	
	
	User findByRole(Role role);
	

}