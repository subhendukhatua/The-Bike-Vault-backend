package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.JobTitle;
import com.MyVehicle.services.JobTitleService;

@RestController
@RequestMapping("/jobTitles")
public class JobTitleController {
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitle")
	public String getJobTitles() {
		return "jobtitle";
	}
	
	@GetMapping("/allJobTitles")
	public List<JobTitle>getAllJobTitles(){
		List<JobTitle> allJobTitles = jobTitleService.getAllJobTitles();
		return allJobTitles;
	}
	
	@GetMapping("/getJobTitle/{id}")
	public JobTitle getJobTitleById(@PathVariable int id) {
		JobTitle jobTitleById = jobTitleService.getJobTitleById(id);
		return jobTitleById;
	}
	
	@PostMapping("/createJobTitle")
	public JobTitle createJobTitle(@RequestBody JobTitle jobTitle) {
		JobTitle createJobTitle = jobTitleService.createJobTitle(jobTitle);
		return createJobTitle;
	}
	
	@PutMapping("/updateJobTitle/{id}")
	public JobTitle updateJobTitle(@RequestBody JobTitle jobTitle,@PathVariable int id) {
		JobTitle updateJobTitle = jobTitleService.updateJobTitle(jobTitle, id);
		return updateJobTitle;
	}
	
	@DeleteMapping("/deleteAllJbTitles")
	public String deleteAllJobTitles() {
		jobTitleService.deleteAllJobTiles();
		return"All jobtitles are deleted";
	}
	
	@DeleteMapping("/deleteJobTitles/{id}")
	public String deleteJobTitleById(@PathVariable int id) {
		jobTitleService.deleteJobTitleById(id);
		return ("Job titles deleted whose id is"+id);
	}
	
	

}
