package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Location;
import com.MyVehicle.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	
	//get all locations
	public List<Location>getAllLocations(){
		List<Location> allLocations = locationRepository.findAll();
		return allLocations;
	}
	
	//get location by id
	public Location getLocationById(int id) {
		Location locationById = locationRepository.findById(id).get();
		return locationById;
	}
	
	//create new location
	public Location createLocation(Location location) {
		Location newLocation = locationRepository.save(location);
		return newLocation;
	}
	
	//update location
	public Location updateLocation(Location location,int id) {
		location.setId(location.getId());
		Location updatedLocation = locationRepository.save(location);
		return updatedLocation;
	}
	
	//delete location by id
	public void deleteLocationById(int id) {
		locationRepository.deleteById(id);
	}
	
	//delete all location
	public void deleteAllLocation() {
		locationRepository.deleteAll();
	}
	
	public List<Location> findByDescriptionContaining(String description) {
		return null;
	}
}
