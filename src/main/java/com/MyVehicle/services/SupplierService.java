package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Supplier;
import com.MyVehicle.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//get all supplier
	public List<Supplier>getAllSuppliers(){
		List<Supplier> allSuppliers = supplierRepository.findAll();
		return allSuppliers;
	}
	
	//get suppliers by id
	public Supplier getById(int id) {
		Supplier supplierById = supplierRepository.findById(id).get();
		return supplierById;
	}
	
	//create a supplier
	public Supplier createSupplier(Supplier supplier) {
		Supplier newSupplier = supplierRepository.save(supplier);
		return newSupplier;
	}
	
	//update a supplier
	public Supplier updateSupplier(Supplier supplier,int id) {
		supplier.setId(supplier.getId());
		Supplier updatedSupplier = supplierRepository.save(supplier);
		return updatedSupplier;
	}
	
	//delete by id
	public void deleteById(int id) {
		supplierRepository.deleteById(id);
	}
	
	
	//delete all supplier
	public void deleteAllSupplier() {
		supplierRepository.deleteAll();
	}
}
