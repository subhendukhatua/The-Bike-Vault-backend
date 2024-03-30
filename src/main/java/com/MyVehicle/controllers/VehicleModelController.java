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

import com.MyVehicle.models.VehicleModel;
import com.MyVehicle.services.VehicleModelService;

@RestController
@RequestMapping("/vehiclemodel")
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicleModels")
	public String getVehicleModels() {
		return "vehicleModel";
	}
	
	
	
	@GetMapping("/allVehiclemodels")
	public List<VehicleModel>getAllVehicleModels(){
		List<VehicleModel> allVehicleModels = vehicleModelService.getAllVehicleModels();
		return allVehicleModels;
	}
	
	
	@GetMapping("/vehicleModel/{id}")
	public VehicleModel getVehicleModelByid(@PathVariable int id) {
		VehicleModel vehicleModelById = vehicleModelService.vehicleModelById(id);
		return vehicleModelById;
	}
	
	@PostMapping("/ceateVehiclemodel")
	public VehicleModel createVehicleModel(@RequestBody VehicleModel vehicleModel) {
		VehicleModel createVehicleModel = vehicleModelService.createVehicleModel(vehicleModel);
		return createVehicleModel;
	}
	
	@PutMapping("/updateVehiclemodel/{id}")
	public VehicleModel updateVehicleModel(@PathVariable int id,@RequestBody VehicleModel vehicleModel) {
		VehicleModel updateVehicleModel = vehicleModelService.updateVehicleModel(vehicleModel, id);
		return updateVehicleModel;
	}
	
	@DeleteMapping("/deleteVehiclemodel/{id}")
	public void deleeteVehicleModelById(@PathVariable int id) {
		vehicleModelService.deleteByIdVehicleModel(id);
	}
	
	@DeleteMapping("/deleteAllVehiclemodels")
	public void deleteAllVehicleModel() {
		vehicleModelService.deleteAllVehicleModels();
		
	}
	


}
