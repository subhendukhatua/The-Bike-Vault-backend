package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.Vehicle;
import com.MyVehicle.services.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@GetMapping("/vehicles")
	public String getVehicles() {
		return "vehicle";
	}
	
	@GetMapping("/getAllVehicles")
	public List<Vehicle>getAllVehicles(){
		List<Vehicle> allVehicles = vehicleService.getAllVehicles();
		return allVehicles;
	}
	
	@GetMapping("/getVehicle/{id}")
	public Vehicle getVehicleById(@PathVariable int id) {
		Vehicle vehicleById = vehicleService.getVehicleById(id);
		return vehicleById;
	}
	
	@PostMapping("/createVehicle")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		Vehicle createVehicle = vehicleService.createVehicle(vehicle);
		return createVehicle;
	}
	
	@PutMapping("/updateVehicle/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle,@PathVariable int id) {
		Vehicle updateVehicle = vehicleService.updateVehicle(vehicle, id);
		return updateVehicle;
	}
	@DeleteMapping("/deleteVehicle/{id}")
	public String deleteVehicleById(@PathVariable int id) {
		vehicleService.deleteVehicleById(id);
		return (" Vehicle deleted successfully whose id is "+id);
	}
	
	@DeleteMapping("/deleteAllVehicle")
	public String deleteAllVehicle() {
		vehicleService.deleteAllVehicle();
		return"All vehicle deleted successfully ";
	}
	


}
