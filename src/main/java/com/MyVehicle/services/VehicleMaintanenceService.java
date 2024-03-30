package com.MyVehicle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleHire;
import com.MyVehicle.models.VehicleMaintenance;
import com.MyVehicle.repositories.VehicleHireRepository;
import com.MyVehicle.repositories.VehicleMaintanenceRepository;

@Service
public class VehicleMaintanenceService {
	
	@Autowired
	private VehicleMaintanenceRepository vehicleMaintanenceRepository;
	
	//Get All VehicleMaintenances
	public List<VehicleMaintenance>vehicleMaintenances(){
		 List<VehicleMaintenance>allVehicleMaintanence=vehicleMaintanenceRepository.findAll();
		 return allVehicleMaintanence;
	}	
	
	//get vehiclemaintanence by id
	public VehicleMaintenance getById(int id) {
		VehicleMaintenance vehicleMaintenanceById = vehicleMaintanenceRepository.findById(id).get();
		return vehicleMaintenanceById;
	}
	
	//create vehicle maintanence 
	public VehicleMaintenance createVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		VehicleMaintenance newVehicleMaintenance = vehicleMaintanenceRepository.save(vehicleMaintenance);
		return newVehicleMaintenance;
	}
	
	//update vehicle mainteenance
	public VehicleMaintenance updateMaintenance(VehicleMaintenance vehicleMaintenance, int id) {
		vehicleMaintenance.setId(vehicleMaintenance.getId());
		VehicleMaintenance updatedMaintenance = vehicleMaintanenceRepository.save(vehicleMaintenance);
		return updatedMaintenance;
	}
	
	///delete by id
	public void deleteById(int id) {
		vehicleMaintanenceRepository.deleteById(id);
	}
	
	//delete all
	public void deleteAllvehicleMintanenece() {
		vehicleMaintanenceRepository.deleteAll();
	}
	
}
