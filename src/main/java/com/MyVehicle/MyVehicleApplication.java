package com.MyVehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.MyVehicle.models.Role;
import com.MyVehicle.models.User;
import com.MyVehicle.repositories.UserRepository;




@SpringBootApplication
public class MyVehicleApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyVehicleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User adminAccount=userRepository.findByRole(Role.ADMIN);
		  
		  if(null==adminAccount) { User user = new User();
		  
		  user.setEmail("subhendu@gmail.com"); 
		  user.setFirstname("subhendu");
		  user.setLastname("khatua"); 
		  user.setRole(Role.ADMIN); 
		  user.setPassword(new BCryptPasswordEncoder().encode("subh"));
		  userRepository.save(user);
		  
		  } 
	}

}
