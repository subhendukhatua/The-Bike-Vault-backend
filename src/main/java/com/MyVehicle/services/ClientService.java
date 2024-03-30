package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Client;
import com.MyVehicle.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	//Add a client
	public Client addClient(Client client) {
		return clientRepository.save(client);
		
	}
	
	//Get All client
	public List<Client> getAllClient(){
		List<Client> allClients = clientRepository.findAll();
		return allClients;
	}
	
	//Get client by id
	public Client getClientById(int id) {
		return clientRepository.findById(id).get();
	}
	
	//Update a client
	public Client updateClinet(Client client,int id) {
		client.setId(client.getId());
		return clientRepository.save(client);
	}
	
	//delete a client by id
	public void deleteClientById(int id) {
		clientRepository.deleteById(id);
	}
	
	//delete all client
	
	public void deleteAllClient() {
		clientRepository.deleteAll();
	}
	
	
		
	
	
	
	
	

}
