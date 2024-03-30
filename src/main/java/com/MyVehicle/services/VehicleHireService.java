package com.MyVehicle.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleHire;
import com.MyVehicle.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Get All VehicleHires
	public List<VehicleHire> findAll(){
		List<VehicleHire> allVehicleHires = vehicleHireRepository.findAll();
		return allVehicleHires;
	}	
	
	//get vehiclehires by id
	public VehicleHire getById(int id) {
		VehicleHire vehicleHireById = vehicleHireRepository.findById(id).get();
		return vehicleHireById;
	}
	
	
	//create vehicle hires
	public VehicleHire createVehicleHire(VehicleHire vehicleHire) {
		VehicleHire newVehicleHire = vehicleHireRepository.save(vehicleHire);
		return newVehicleHire;
	}
	
	//update vehicle hire
	public VehicleHire updateVehicleHire(VehicleHire vehicleHire,int id) {
		vehicleHire.setId(vehicleHire.getId());
		VehicleHire updatedVehicleHire = vehicleHireRepository.save(vehicleHire);
		return updatedVehicleHire;
	}
	
	//delete vehicle hire
	public void deletevehicleHire(int id) {
		vehicleHireRepository.deleteById(id);
	}
	
	//delete all vehicle hires
	public void deleteAllVehicleHires() {
		vehicleHireRepository.deleteAll();
	}
}
