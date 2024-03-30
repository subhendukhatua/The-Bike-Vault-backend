package com.MyVehicle.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	
	 
	
	@GetMapping("/profile")
	public String getProfile() {
		return "profile";
	}


}
