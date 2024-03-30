package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.MyVehicle.models.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//Employee findById(int id);
	Employee findByUsername(String username);
	
	@Query(value="select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%", nativeQuery=true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);

}
