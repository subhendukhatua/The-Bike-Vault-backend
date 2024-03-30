package com.MyVehicle.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Country;
import com.MyVehicle.repositories.CountryRepository;

@Service
public class CountryService {
	@Autowired
	 private CountryRepository countryRepository;
	
	//get all country
	public List<Country>getCountries(){
		List<Country> countryList = countryRepository.findAll();
		return countryList;
	}
	
	
	//add new country
	public Country save(Country country) {
		Country newCountry = countryRepository.save(country);
		return newCountry;
	}
	
	//get by id
	public Country getCountryById(int id) {
		return countryRepository.findById(id).get();
	}
	
	//update a country
	public Country updateCountry(Country country,int id) {
		country.setId(country.getId());
		Country updatedCountry = countryRepository.save(country);
		return updatedCountry;
	}
	
	//delete a country by id
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}
	
	
	//delete all country
	public void deleteAllCountry() {
		countryRepository.deleteAll();
	}
}	
