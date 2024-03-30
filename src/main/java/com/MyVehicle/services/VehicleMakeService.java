package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleMake;
import com.MyVehicle.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//get all vahicle makes
	public List<VehicleMake>getAllVehicleMakes(){
		List<VehicleMake> allVehicleMakes = vehicleMakeRepository.findAll();
		return allVehicleMakes;
	}
	
	//get vehicle make by id
	public VehicleMake getById(int id) {
		VehicleMake vehicleMakeById = vehicleMakeRepository.findById(id).get();
		return vehicleMakeById;
	}
	
	//create vehicle make
	public VehicleMake create(VehicleMake vehicleMake) {
		VehicleMake newVehicleMake = vehicleMakeRepository.save(vehicleMake);
		return newVehicleMake;
	}
	
	//update vhicle make
	public VehicleMake updateVehicleMake(VehicleMake vehicleMake,int id) {
		vehicleMake.setId(vehicleMake.getId());
		VehicleMake updatedVehicleMake = vehicleMakeRepository.save(vehicleMake);
		return updatedVehicleMake;
	}
	
	//delete by id
	public void deleteVehicleMakeByid(int id) {
		vehicleMakeRepository.deleteById(id);
	}
	
	//delete all
	public void deleteAllVehicleMake() {
		vehicleMakeRepository.deleteAll();
	}
	

}
