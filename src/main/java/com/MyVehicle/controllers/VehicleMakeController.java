package com.MyVehicle.controllers;

import java.util.List;

import org.hibernate.query.sqm.SqmTreeTransformationLogger;
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

import com.MyVehicle.models.VehicleMake;
import com.MyVehicle.repositories.VehicleMakeRepository;
import com.MyVehicle.services.VehicleMakeService;

@RestController
@RequestMapping("/vehiclemake")
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehicleMakes")
	public String getVehicleMakes() {
		return "vehicleMake";
	}
	
	
	@GetMapping("/getAllVehiclemakes")
	public List<VehicleMake>getAllVehicleMakes(){
		List<VehicleMake> allVehicleMakes = vehicleMakeService.getAllVehicleMakes();
		return allVehicleMakes;
	}
	
	@GetMapping("/getVehicleMakesById")
	public VehicleMake getById(@PathVariable int id) {
		VehicleMake byId = vehicleMakeService.getById(id);
		return byId;
	}
	
	@PostMapping("/createVehicleMakes")
	public VehicleMake createVehicleMake(@RequestBody VehicleMake vehicleMake) {
		VehicleMake create = vehicleMakeService.create(vehicleMake);
		return create;
	}
	
	@PutMapping("/updateVehicleMakes")
	public VehicleMake updateVehicleMake(@RequestBody VehicleMake vehicleMake,@PathVariable int id) {
		VehicleMake updateVehicleMake = vehicleMakeService.updateVehicleMake(vehicleMake, id);
		return updateVehicleMake;
	}
	
	@DeleteMapping("/deleteVehicleMakesById/{id}")
	public String deleteByIdVehicleMakes(@PathVariable int id) {
		vehicleMakeService.deleteVehicleMakeByid(id);
		return ("Vehicle makes deleted whose id "+id);
	}
	
	@DeleteMapping("/deleteAllVehicleMakes")
	public String deleteAllVehicleMakes() {
		vehicleMakeService.deleteAllVehicleMake();
		return "All vehicleMakes are deleted";
	}
	
	

}
