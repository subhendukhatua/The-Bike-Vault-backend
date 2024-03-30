package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.VehicleModel;
import com.MyVehicle.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//get all vehicle models
	public List<VehicleModel>getAllVehicleModels(){
		List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
		return allVehicleModels;
	}
	
	//find by id
	public VehicleModel vehicleModelById(int id) {
		VehicleModel vehicleModelById = vehicleModelRepository.findById(id).get();
		return vehicleModelById;
	}
	
	//cerate vehicle model by id
	public VehicleModel createVehicleModel(VehicleModel vehicleModel) {
		VehicleModel newVehicleModel = vehicleModelRepository.save(vehicleModel);
		return newVehicleModel;
	}
	
	//update vehicle model
	public VehicleModel updateVehicleModel(VehicleModel vehicleModel,int id) {
		vehicleModel.setId(vehicleModel.getId());
		VehicleModel updatedVehicleModel = vehicleModelRepository.save(vehicleModel);
		return updatedVehicleModel;
	}
	
	//delete by id
	public void deleteByIdVehicleModel(int id) {
		vehicleModelRepository.deleteById(id);
	}
	
	//delete all vehicle models
	public void deleteAllVehicleModels() {
		vehicleModelRepository.deleteAll();
	}

}
