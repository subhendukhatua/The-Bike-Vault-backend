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

import com.MyVehicle.models.Client;
import com.MyVehicle.models.Country;
import com.MyVehicle.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	Client client = new Client();
	Country country = new Country();
	

	@GetMapping("/getClient")
	public String getClient() {
		return "client";
	}
	
	
	//create a client
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}
	
	//get all Client
	@GetMapping("/getAllClient")
	public List<Client> getClients(){
		List<Client> allClient = clientService.getAllClient();
		return allClient;
	}
	
	//get client by Id
	@GetMapping("/getClient/{id}")
	public Client getClientById(@PathVariable int id) {
		Client clientById = clientService.getClientById(id);
		return clientById;
	}
	
	//update a client
	@PutMapping("/updateClient/{id}")
	public Client updateClient(@RequestBody Client client,@PathVariable int id) {
		Client updateClinet = clientService.updateClinet(client, id);
		return updateClinet;
	}
	
	//delete a client By Id
	@DeleteMapping("/deleteClient/{id}")
	public void deleteClientById(@PathVariable int id) {
		clientService.deleteClientById(id);
	}
	
	
	//delete all client
	@DeleteMapping("/deleteAllClient")
	public void deleteAllClient() {
		clientService.deleteAllClient();
	}
	
	//add country
	@PostMapping("/addClientCountry/{id}/{id2}")
	public void addClientCountry(@PathVariable int id,@PathVariable int id2) {
		
	}
	
	

}
