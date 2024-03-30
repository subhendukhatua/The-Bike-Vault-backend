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

import com.MyVehicle.models.State;
import com.MyVehicle.services.StateService;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	private StateService stateService;
	

	@GetMapping("/state")
	public String getStates() {
		return "state";
	}
	
	@GetMapping("/getAllStates")
	public List<State>getAllStates(){
		List<State> allStates = stateService.getAllStates();
		return allStates;
	}
	
	@GetMapping("/getState/{id}")
	public State getStateById(@PathVariable int id) {
		State stateById = stateService.getStateById(id);
		return stateById;
	}
	
	@PostMapping("/createState")
	public State createState(@RequestBody State state) {
		State newState = stateService.newState(state);
		return newState;
	}
	
	@PutMapping("/updatestate/{id}")
	public State updateState(@RequestBody State state,@PathVariable int id) {
		State updateState = stateService.updateState(state, id);
		return updateState;
	}
	
	@DeleteMapping("/deleteState/{id}")
	public String deleteStateById(@PathVariable int id) {
		stateService.deleteStateById(id);
		return (" State is deleted whose id "+id);
	}
	
	
	@DeleteMapping("/deleteAllStates")
	public String deleteAllStates() {
		stateService.deleteAllState();
		return "All states are deleted";
	}

}
