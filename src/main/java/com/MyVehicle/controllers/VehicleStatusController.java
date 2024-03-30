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

import com.MyVehicle.models.VehicleStatus;
import com.MyVehicle.services.VehicleStatusService;

@RestController
@RequestMapping("/vehicleStatus")
public class VehicleStatusController {
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	

	@GetMapping("/vehicleStatus")
	public String getVehicleStatus() {
		return "vehicleStatus";
	}
	
	
	@GetMapping("/getAllVehiclestatus")
	public List<VehicleStatus>getAllVehicleStatus(){
		List<VehicleStatus> allStatus = vehicleStatusService.getAllStatus();
		return allStatus;
	}
	
	@GetMapping("/getVehiclestatus/{id}")
	public VehicleStatus getVehicleStatusById(@PathVariable int id) {
		VehicleStatus byId = vehicleStatusService.getById(id);
		return byId;
	}
	
	@PostMapping("/createVehiclestatus")
	public VehicleStatus ccreateVehicleStatus(@RequestBody VehicleStatus vehicleStatus) {
		VehicleStatus createVehicleStatus = vehicleStatusService.createVehicleStatus(vehicleStatus);
		return createVehicleStatus;
	}
	
	@PutMapping("/updateVehiclestatus/{id}")
	public VehicleStatus updateVehicleStatus(@RequestBody VehicleStatus vehicleStatus,@PathVariable int id) {
		VehicleStatus updateVehicleStatus = vehicleStatusService.updateVehicleStatus(vehicleStatus, id);
		 return updateVehicleStatus;
	}
	
	@DeleteMapping("/deleteVehiclestatus/{id}")
	public void deletevehicleStatusById(@PathVariable int id) {
		vehicleStatusService.deleteVehicleStatusById(id);
	}
	
	@DeleteMapping("/deleteAllVehiclestatus")
	public void deleteAllVehicleStatus() {
		vehicleStatusService.deleteAllVehicleStatus();
	}

}
