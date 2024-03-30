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

import com.MyVehicle.models.VehicleHire;
import com.MyVehicle.services.VehicleHireService;
import com.MyVehicle.services.VehicleService;

@RestController
@RequestMapping("/vehicleHire")
public class VehicleHireController {
	
	@Autowired
	private VehicleHireService vehicleHireService;
	
	@GetMapping("/vehicleHires")
	public String getVehicleHires() {
		return "vehicleHire";
	}
	
	@GetMapping("/getAllvehicleHires")
	public List<VehicleHire>getAllVehicleHires(){
		List<VehicleHire> findAll = vehicleHireService.findAll();
		return findAll;
	}
	
	@GetMapping("/getVehicleHire/{id}")
	public VehicleHire getVehicleHireById(@PathVariable int id) {
		VehicleHire byId = vehicleHireService.getById(id);
		return byId;
	}
	
	@PostMapping("/createVehicleHire")
	public VehicleHire createVehicleHire(@RequestBody VehicleHire vehicleHire) {
		VehicleHire createVehicleHire = vehicleHireService.createVehicleHire(vehicleHire);
		return createVehicleHire;
	}
	
	@PutMapping("/updateVehicleHire/{id}")
	public VehicleHire updateVehicleHire(@RequestBody VehicleHire vehicleHire,@PathVariable int id) {
		VehicleHire updateVehicleHire = vehicleHireService.updateVehicleHire(vehicleHire, id);
		return updateVehicleHire;
	}
	
	@DeleteMapping("/deleteVehicleHire/{id}")
	public String deleteVehicleHireById(@PathVariable int id) {
		vehicleHireService.deletevehicleHire(id);
		return ("vehicle Hire deleted Successfully whose id "+id);
	}
	
	@DeleteMapping("/deleteAllVehicleHires")
	public String deleteAllVehicleHire() {
		vehicleHireService.deleteAllVehicleHires();
		return "All Vehicle Hires deleted Successfully";
	}


}
