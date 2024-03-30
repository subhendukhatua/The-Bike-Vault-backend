package com.MyVehicle.services;

import java.util.List;

import org.hibernate.event.internal.EntityCopyAllowedLoggedObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleMovement;
import com.MyVehicle.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//get all vehicle movements
	public List<VehicleMovement>getAllVehicleMovements(){
		List<VehicleMovement> allVehicleMovements = vehicleMovementRepository.findAll();
		return allVehicleMovements;
	}
	
	//vehicle movements by id
	public VehicleMovement getById(int id) {
		VehicleMovement vehicleMovementById = vehicleMovementRepository.findById(id).get();
		return vehicleMovementById;
	}
	
	//create a vehicle movements
	public VehicleMovement createVehicleMovement(VehicleMovement vehicleMovement) {
		VehicleMovement newVehicleMovement = vehicleMovementRepository.save(vehicleMovement);
		return newVehicleMovement;
	}
	
	//update vehice movements
	public VehicleMovement updateVehicleMovement(VehicleMovement vehicleMovement,int id) {
		vehicleMovement.setId(vehicleMovement.getId());
		VehicleMovement updatedVehicleMovement = vehicleMovementRepository.save(vehicleMovement);
		return updatedVehicleMovement;
	}
	
	//delte by id
	public void deleteVehicleMovementsById(int id) {
		vehicleMovementRepository.deleteById(id);;
	}
	
	//delete all
	public void deleteAllVehicleMovements() {
		vehicleMovementRepository.deleteAll();
	}

}
