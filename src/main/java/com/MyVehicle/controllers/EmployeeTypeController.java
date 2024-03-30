package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.EmployeeType;
import com.MyVehicle.services.EmployeeTypeService;

@RestController
@RequestMapping("/employeeTypes")
public class EmployeeTypeController {
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeeType")
	public String getEmployeeType() {
		return "employeetype";
	}
	
	@GetMapping("/getAllEmployeeTypes")
	public List<EmployeeType>allEmployeeTypes(){
		List<EmployeeType> employeeTypes = employeeTypeService.employeeTypes();
		return employeeTypes;
	}
	
	@GetMapping("/getEmployeetype/{id}")
	public EmployeeType getEmployeeTypesById(@PathVariable int id) {
		EmployeeType employeeTypeById = employeeTypeService.getById(id);
		return employeeTypeById;
	}
	
	@PostMapping("/createEmployeeType")
	public EmployeeType createEmployeeType(@RequestBody EmployeeType employeeType) {
		EmployeeType createEmployeeType = employeeTypeService.createEmployeeType(employeeType);
		return createEmployeeType;
		
	}
	
	@PutMapping("/updateEmployeeType/{id}")
	public EmployeeType updateEmployeeType(@RequestBody EmployeeType employeeType,@PathVariable int id) {
		EmployeeType updateEmployeeType = employeeTypeService.updateEmployeeType(employeeType, id);
		return updateEmployeeType;
		
	}
	
	@DeleteMapping("/deleteEmployeeType/{id}")
	public String deleteEmployeeType(@PathVariable int id) {
		employeeTypeService.deleteEmployeeTypeById(id);
		return ("Employee Type is deleted successfully whose id "+id);
	}
	
	@DeleteMapping("/deleteAllEmployees")
	public String deleteAllEmployee() {
		employeeTypeService.deleteAll();
		return ("All employee types are deleted");
	}
	
	
	
	
	


}
