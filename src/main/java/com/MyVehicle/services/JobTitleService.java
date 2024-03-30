package com.MyVehicle.services;

import java.util.List;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.MyVehicle.models.JobTitle;
import com.MyVehicle.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//get all job titles
	public List<JobTitle>getAllJobTitles(){
		List<JobTitle> allJobTitles = jobTitleRepository.findAll();
		return allJobTitles;
	}
	
	
	//get job title by id
	public JobTitle getJobTitleById(int id) {
		JobTitle jobTitleByid = jobTitleRepository.findById(id).get();
		return jobTitleByid;
	}
	
	//create new job title
	public JobTitle createJobTitle(JobTitle jobTitle) {
		JobTitle newJobTitle = jobTitleRepository.save(jobTitle);
		return newJobTitle;
	}
	
	//update job title
	public JobTitle updateJobTitle(JobTitle jobTitle,int id) {
		jobTitle.setId(jobTitle.getId());
		JobTitle updatedJobTitle = jobTitleRepository.save(jobTitle);
		return updatedJobTitle;
	}
	
	//delete job title byyId
	public void deleteJobTitleById(int id) {
		jobTitleRepository.deleteById(id);
	}
	
	//delete all job titiles
	public void deleteAllJobTiles() {
		jobTitleRepository.deleteAll();
	}

}
