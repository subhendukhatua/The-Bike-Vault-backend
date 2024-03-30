package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.State;
import com.MyVehicle.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	//get All states
	public List<State>getAllStates(){
		List<State> allStates = stateRepository.findAll();
		return allStates;
	}
	
	//get states by id
	public State getStateById(int id) {
		State stateById = stateRepository.findById(id).get();
		return stateById;
	}
	
	//create state
	public State newState(State state) {
		State newState = stateRepository.save(state);
		return newState;
	}
	
	//update state
	public State updateState(State state,int id) {
		state.setId(state.getId());
		State updatedState = stateRepository.save(state);
		return updatedState;
				
	}
	
	//delete a state by id
	public void deleteStateById(int id) {
		stateRepository.deleteById(id);
	}
	
	//delete all states
	public void deleteAllState() {
		stateRepository.deleteAll();
	}

}
