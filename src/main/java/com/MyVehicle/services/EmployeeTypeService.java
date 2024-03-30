package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.EmployeeType;
import com.MyVehicle.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//create employeeType
	public EmployeeType createEmployeeType(EmployeeType employeeType) {
		EmployeeType newEmployeeType = employeeTypeRepository.save(employeeType);
		return newEmployeeType;
	}
	
	//get all employeeTypes
	public List<EmployeeType>employeeTypes(){
		List<EmployeeType> allEmployeeTypes = employeeTypeRepository.findAll();
		return allEmployeeTypes;
	}
	
	//getEmployeeType by id
	public EmployeeType getById(int id) {
		EmployeeType employeeType = employeeTypeRepository.findById(id).get();
		return employeeType;
	}
	
	//update employeetype
	public EmployeeType updateEmployeeType(EmployeeType employeeType,int id) {
		employeeType.setId(employeeType.getId());
		EmployeeType updatedEmployeeType = employeeTypeRepository.save(employeeType);
		return updatedEmployeeType;
	}
	
	//delete employee by id
	public void deleteEmployeeTypeById(int id) {
		employeeTypeRepository.deleteById(id);
	}
	
	//delete all employee
	public void deleteAll() {
		employeeTypeRepository.deleteAll();
	}

}
