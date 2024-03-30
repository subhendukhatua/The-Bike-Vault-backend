package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.Country;
import com.MyVehicle.services.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	
	//get all countries
	@GetMapping("/countries")
	public String getCountries(Model model) {
		List<Country>countryList=countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		return "country";
	}
	
	//add new Country
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
			countryService.save(country);
			return "redirect:/countries";
	}
	
	//find By Id
	@RequestMapping("/countries/findById/{id}")
	@ResponseBody
	public Country findById(@PathVariable int id) {
		return countryService.getCountryById(id);
	}
	
	
	@GetMapping("/getAllCountries")
	public List<Country>getAllCountries(){
		List<Country> countries = countryService.getCountries();
		return countries;
	}
	
	@GetMapping("/getCountry/{id}")
	public Country getCountryById(@PathVariable int id) {
		Country countryById = countryService.getCountryById(id);
		return countryById;
	}
	
	
	@PostMapping("/createCountry")
	public Country createCountry(@RequestBody  Country country) {
		Country newCountry = countryService.save(country);
		return newCountry;
	}
	
	@PutMapping("/updateCountry/{id}")
	public Country updateCountry(@RequestBody Country country,@PathVariable int id) {
		Country updateCountry = countryService.updateCountry(country, id);
		return updateCountry;
	}
	
	@DeleteMapping("/deleteCountry/{id}")
	public String deleteCountryById(@PathVariable int id) {
		countryService.deleteCountry(id);
		return ("Country deleted successfully which id is "+id);
		
	}
	
	@DeleteMapping("/deleteAllCountry")
	public String deleteAllCountry() {
		countryService.deleteAllCountry();
		return "All countries are deleted successfully";
	}
	
	
	
	
	
	
}
