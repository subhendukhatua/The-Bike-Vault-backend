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

import com.MyVehicle.models.VehicleMovement;
import com.MyVehicle.services.VehicleMovementService;

@RestController
@RequestMapping("/Vehiclemovement")
public class VehicleMovementController {
	
	
	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@GetMapping("/vehicleMovements")
	public String getVehicleMovements() {
		return "vehicleMovement";
	}
	
	@GetMapping("/allVehiclemovements")
	public List<VehicleMovement>getAllVehicleMovements(){
		List<VehicleMovement> allVehicleMovements = vehicleMovementService.getAllVehicleMovements();
		return allVehicleMovements;
	}
	
	@GetMapping("/vehiclemovement/{id}")
	public VehicleMovement getVehicleMovementById(@PathVariable int id) {
		VehicleMovement byId = vehicleMovementService.getById(id);
		return byId;
	}
	
	
	@PostMapping("/createVehicleMovement")
	public VehicleMovement createVehicleMovement(VehicleMovement vehicleMovement) {
		VehicleMovement createVehicleMovement = vehicleMovementService.createVehicleMovement(vehicleMovement);
		return createVehicleMovement;
	}
	
	@PutMapping("/updateVehiclemovement/{id}")
	public VehicleMovement updateVehicleMovement(@RequestBody VehicleMovement vehicleMovement,@PathVariable int id) {
		VehicleMovement updateVehicleMovement = vehicleMovementService.updateVehicleMovement(vehicleMovement, id);
		return updateVehicleMovement;
	}
	
	@DeleteMapping("/deleteVehiclemovement/{id}")
	public void deleteVehicleMovementById(@PathVariable int id) {
		vehicleMovementService.deleteVehicleMovementsById(id);
	}
	
	@DeleteMapping("/deleteAllVehiclemovement")
	public void deleteAllVehicleMovement() {
		vehicleMovementService.deleteAllVehicleMovements();
	}
}
