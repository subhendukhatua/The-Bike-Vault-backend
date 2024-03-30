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

import com.MyVehicle.models.Location;
import com.MyVehicle.services.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/location")
	public String getLocations() {
		return "location";
	}
	
	
	@GetMapping("/getAllLocations")
	public List<Location>getAllLocations(){
		List<Location> allLocations = locationService.getAllLocations();
		return allLocations;
	}
	
	@GetMapping("/getLocation/{id}")
	public Location getLocationById(@PathVariable int id) {
		Location locationById = locationService.getLocationById(id);
		return locationById;
	}
	
	@PostMapping("/createLocation")
	public Location createLocation(Location location) {
		Location createLocation = locationService.createLocation(location);
		return createLocation;
	}
	
	@PutMapping("/updateLocation/{id}")
	public Location updateLocation(@RequestBody Location location,@PathVariable int id) {
		Location updateLocation = locationService.updateLocation(location, id);
		return updateLocation;
	}
	
	@DeleteMapping("/delteLocation/{id}")
	public String deleteLocationById(int id) {
		locationService.deleteLocationById(id);
		return ("Location deleted whose id "+id);
	}
	
	@DeleteMapping("/deleteAllLocation")
	public String deleteAllLocations() {
		locationService.deleteAllLocation();
		return "All locaions deleted";
	}
	
	

}
