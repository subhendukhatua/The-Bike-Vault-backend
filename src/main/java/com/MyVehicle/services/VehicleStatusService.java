package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleStatus;
import com.MyVehicle.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	//get all vehicle sataus
	public List<VehicleStatus>getAllStatus(){
		List<VehicleStatus> allStatus = vehicleStatusRepository.findAll();
		return allStatus;
	}
	
	//get by id
	public VehicleStatus getById(int id) {
		VehicleStatus vehicleStatusById = vehicleStatusRepository.findById(id).get();
		return vehicleStatusById;
	}
	
	//create new vehicle status
	public VehicleStatus createVehicleStatus(VehicleStatus vehicleStatus) {
		VehicleStatus newVehicleStatus = vehicleStatusRepository.save(vehicleStatus);
		return newVehicleStatus;
		
	}
	
	//update a vehicle status
	public VehicleStatus updateVehicleStatus(VehicleStatus vehicleStatus,int id) {
		vehicleStatus.setId(vehicleStatus.getId());
		VehicleStatus updatedVehicleStatus = vehicleStatusRepository.save(vehicleStatus);
		return updatedVehicleStatus;
	}
	
	//delete by id
	public void deleteVehicleStatusById(int id) {
		vehicleStatusRepository.deleteById(id);
	}
	
	//delete all
	public void deleteAllVehicleStatus() {
		vehicleStatusRepository.deleteAll();
	}

}
