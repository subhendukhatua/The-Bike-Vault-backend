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

import com.MyVehicle.models.VehicleMaintenance;
import com.MyVehicle.services.VehicleMaintanenceService;

@RestController
@RequestMapping("/vehiclemaintenances")
public class VehicleMaintenanceController {
	
	@Autowired
	private VehicleMaintanenceService vehicleMaintanenceService;
	

	@GetMapping("/vehiclemaintenance")
	public String getVehicleMaintenance() {
		return "vehiclemaintenance";
	}
	
	@GetMapping("/getAllVehiclemaintenance")
	public List<VehicleMaintenance>getAllVehicleMaintenances(){
		List<VehicleMaintenance> vehicleMaintenances = vehicleMaintanenceService.vehicleMaintenances();
		return vehicleMaintenances;
	}
	
	@GetMapping("/getVehiclemaintenanceById/{id}")
	public VehicleMaintenance getByIdVehicleMaintenance(@PathVariable int id) {
		VehicleMaintenance byId = vehicleMaintanenceService.getById(id);
		return byId;
	}
	
	@PostMapping("/createVehiclemaintenance")
	public VehicleMaintenance createVehicleMaintenance(@RequestBody VehicleMaintenance vehicleMaintenance) {
		VehicleMaintenance createVehicleMaintenance = vehicleMaintanenceService.createVehicleMaintenance(vehicleMaintenance);
		return createVehicleMaintenance;
	}
	
	@PutMapping("/updateVehiclemaintenance")
	public VehicleMaintenance updateVehicleMaintenance(@RequestBody VehicleMaintenance vehicleMaintenance,@PathVariable int id) {
		VehicleMaintenance updateMaintenance = vehicleMaintanenceService.updateMaintenance(vehicleMaintenance, id);
		return updateMaintenance;
	}
	
	@DeleteMapping("/deleteVehiclemaintenance/{id}")
	public String deleteVehicleMaintanenceById(@PathVariable int id) {
		vehicleMaintanenceService.deleteById(id);
		return ("VehicleMaintenance deleted whose id "+id);
	}
	
	@DeleteMapping("/deleteAllVehiclemaintenance")
	public String deleteAllVehiclemaintenance() {
		vehicleMaintanenceService.deleteAllvehicleMintanenece();
		return "All vehicleMaintenancee are deleted";
	}
	
		
	
	
	
	
	

}
