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

import com.MyVehicle.models.Supplier;
import com.MyVehicle.services.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	

	@GetMapping("/supplier")
	public String getSuppliers() {
		return "supplier";
	}
	
	@GetMapping("/getAllSuppliers")
	public List<Supplier>getAllSuppliers(){
		List<Supplier> allSuppliers = supplierService.getAllSuppliers();
		return allSuppliers;
		
	}
	
	@GetMapping("/getSupplier/{id}")
	public Supplier getSupplierById(@PathVariable int id) {
		Supplier byId = supplierService.getById(id);
		return byId;
	}
	
	@PostMapping("/createSupplier")
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		Supplier createSupplier = supplierService.createSupplier(supplier);
		return createSupplier;
	}
	
	@PutMapping("/updateSupplier/{id}")
	public Supplier updateSupplier(@RequestBody Supplier supplier,@PathVariable int id) {
		Supplier updateSupplier = supplierService.updateSupplier(supplier, id);
		return updateSupplier;
	}
	
	@DeleteMapping("/deleteSupplier/{id}")
	public String deleteSupplierById(@PathVariable int id) {
		supplierService.deleteById(id);
		return (" supplier deleted whose id "+id);
	}
	
	@DeleteMapping("/deleteAllSuppliers")
	public String deleteAllSupplier() {
		supplierService.deleteAllSupplier();
		return "All suppliers are deleted";
	}


}
