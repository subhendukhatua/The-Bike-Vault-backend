package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.User;
import com.MyVehicle.repositories.UserRepository;

//@Service
//public class UserService {
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	
////	@Autowired 
////	private BCryptPasswordEncoder encoder;
//	
//	//Get User By Id
//		public User findById(int id) {
//			return userRepository.findById(id).orElse(null);
//		}	
//		
//		//get all user
//		public List<User>getAllUsers(){
//			List<User> allusers = userRepository.findAll();
//			return allusers;
//		}
//		
//		//create user
//		public User createUser(User user) {
//			User newUser = userRepository.save(user);
//			return newUser;
//		}
//		
////		//update user
////		public void updateUser(User user) {
////			user.setPassword(encoder.encode(user.getPassword()));
////			userRepository.save(user);
////		}
//		
//		//delete user by id
//		public void deleteUserById(int id) {
//			userRepository.deleteById(id);
//		}

//}

public interface UserService {
	
	UserDetailsService userDetailsService();
}

