package com.MyVehicle.services;

import java.util.List;
import java.util.function.IntToDoubleFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Employee;
import com.MyVehicle.models.User;
import com.MyVehicle.repositories.EmployeeRepository;
import com.MyVehicle.repositories.UserRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//get all employee
	public List<Employee>getAllEmployee(){
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	//get employee by id
	public Employee getEmployeeById(int id) {
		Employee findById = employeeRepository.findById(id).get();
		return findById;
	}
	
	//create an employee
	public Employee createEmployee(Employee employee) {
		Employee newEmployee = employeeRepository.save(employee);
		return newEmployee;
		
	}
	
	//update an employee
	public Employee updatEmployee(Employee employee,int id) {
		employee.setId(employee.getId());
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	//delete employee by id
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
	
	//delete all employee
	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
	}
	
	//get employee by Username
	public Employee findByUsername(String username) {
		Employee employeeByUsername = employeeRepository.findByUsername(username);
		return employeeByUsername;
		
	}
	
	//get employee by keyword
	public List<Employee> getEmpliyeeByKeyword(String keyword) {
		List<Employee> findByKeyword = employeeRepository.findByKeyword(keyword);
		return findByKeyword;
	}
	
	/*
	 * //Set the Username of the employee where firstname and lastname match
	 * 
	 * public void assignUsername(int id){ Employee employee =
	 * employeeRepository.findById(id).orElse(null); try { User user =
	 * userRepository.findByFirstnameAndLastname( employee.getFirstname(),
	 * employee.getLastname()); System.out.println(user);
	 * employee.setUsername(user.getUsername()); employeeRepository.save(employee);
	 * } catch (Exception ex){ System.out.println(ex.getMessage());
	 * 
	 * } }
	 */
	

}
