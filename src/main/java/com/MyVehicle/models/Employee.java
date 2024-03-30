package com.MyVehicle.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person{
	
	
	public Employee(Integer id, String firstname, String lastname, String othername, String fullName, String title,
			String initials, String socialSecurityNumber, String gender, String maritalStatus, Country country,
			Integer countryid, State state, Integer stateid, Date dateOfBirth, String city, String address,
			String phone, String mobile, String email, String photo) {
		super(id, firstname, lastname, othername, fullName, title, initials, socialSecurityNumber, gender, maritalStatus,
				country, countryid, state, stateid, dateOfBirth, city, address, phone, mobile, email, photo);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	@JoinColumn(name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private Integer employeetypeid;
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="jobtitleid", insertable=false, updatable=false)
	private JobTitle jobTitle;
	private Integer jobtitleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;
	

}
