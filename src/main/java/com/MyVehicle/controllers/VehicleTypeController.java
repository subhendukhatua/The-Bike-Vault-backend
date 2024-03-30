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

import com.MyVehicle.models.VehicleType;
import com.MyVehicle.services.VehicleTypeService;

@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicleTypes")
	public String getVehicleTypes() {
		return "vehicleType";
	}
	
	@GetMapping("/getAllVehicleTypes")
	public List<VehicleType>getAllVehicleTypes(){
		List<VehicleType> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();
		return allVehicleTypes;
	}
	
	
	@GetMapping("/getVehicleTypes/{id}")
	public VehicleType getById(@PathVariable int id) {
		VehicleType vehicleTypeById = vehicleTypeService.getVehicleTypeById(id);
		return vehicleTypeById;
	}
	
	@PostMapping("/createVehicleType")
	public VehicleType createVehicleType(@RequestBody VehicleType vehicleType) {
		VehicleType createVehicleType = vehicleTypeService.createVehicleType(vehicleType);
		return createVehicleType;
	}
	
	@PutMapping("/updateVehicleType/{id}")
	public VehicleType updateVehicleType(@RequestBody VehicleType vehicleType,@PathVariable int id) {
		VehicleType updateVehicleType = vehicleTypeService.updateVehicleType(vehicleType, id);
		return updateVehicleType;
	}
	
	
	@DeleteMapping("/deleteVehicleType/{id}")
	public void deleteById(@PathVariable int id) {
		vehicleTypeService.deleteVehicleTypeById(id);
	}
	
	@DeleteMapping("/deleteAllVehicleTypes")
	public void deleteAllVehicleTypes() {
		vehicleTypeService.deleteAllVehicleTypes();
	}

}
