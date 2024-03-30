package com.MyVehicle.services;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleType;
import com.MyVehicle.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//get all vehicleTypes
	public List<VehicleType>getAllVehicleTypes(){
		List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();
		return allVehicleTypes;
	}
	
	//get by id
	public VehicleType getVehicleTypeById(int id) {
		VehicleType vehicleTypeById = vehicleTypeRepository.findById(id).get();
		return vehicleTypeById;
	}
	
	//create vehicle types
	public VehicleType createVehicleType(VehicleType vehicleType) {
		VehicleType newVehicleType = vehicleTypeRepository.save(vehicleType);
		return newVehicleType;
	}
	
	//update vehicleType
	public VehicleType updateVehicleType(VehicleType vehicleType,int id) {
		vehicleType.setId(vehicleType.getId());
		VehicleType updatedVehicleType = vehicleTypeRepository.save(vehicleType);
		return updatedVehicleType;
	}
	
	//delete by id
	public void deleteVehicleTypeById(int id) {
		vehicleTypeRepository.deleteById(id);
	}
	
	//delete all vehicle types
	public void deleteAllVehicleTypes() {
		vehicleTypeRepository.deleteAll();
	}

}
