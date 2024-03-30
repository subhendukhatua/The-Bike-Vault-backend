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

import com.MyVehicle.models.Employee;
import com.MyVehicle.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public String getEmployee() {
		return "employee";
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee>getAllEmployees(){
		List<Employee> allEmployee = employeeService.getAllEmployee();
		return allEmployee;
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee employeeById = employeeService.getEmployeeById(id);
		return employeeById;
	}
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.createEmployee(employee);
		return newEmployee;
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
		Employee updatEmployee = employeeService.updatEmployee(employee, id);
		return updatEmployee;
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteById(id);
		return ("Employee deleted successfully whose id "+id);
	}
	
	@DeleteMapping("/deleteAllEmployee")
	public String deleteAllEmployee() {
		employeeService.deleteAllEmployee();
		return "All employee deleted successfully";
	}
	


}
