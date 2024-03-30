package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Vehicle;
import com.MyVehicle.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//getAll vehicle 
	public List<Vehicle>getAllVehicles(){
		List<Vehicle> allVehicles = vehicleRepository.findAll();
		return allVehicles;
	}
	
	
	//vehicle by id
	public Vehicle getVehicleById(int id) {
		Vehicle vehicleByid = vehicleRepository.findById(id).get();
		return vehicleByid;
	}
	
	//create new Vehicle
	public Vehicle createVehicle(Vehicle vehicle) {
		Vehicle newVehicle = vehicleRepository.save(vehicle);
		return newVehicle;
	}
	
	//update vehicle
	public Vehicle updateVehicle(Vehicle vehicle,int id) {
		vehicle.setId(vehicle.getId());
		Vehicle updatedVehicle = vehicleRepository.save(vehicle);
		return updatedVehicle;
	}
	
	//delete by id
	public void deleteVehicleById(int id) {
		vehicleRepository.deleteById(id);
	}
	
	//delete all vehicle
	public void deleteAllVehicle() {
		vehicleRepository.deleteAll();
	}
	
}
