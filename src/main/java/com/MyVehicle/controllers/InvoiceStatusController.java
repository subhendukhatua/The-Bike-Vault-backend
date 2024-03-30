package com.MyVehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.InvoiceStatus;
import com.MyVehicle.services.InvoiceStatusService;

@RestController
@RequestMapping("/invoiceStatus")
public class InvoiceStatusController {
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoiceStatus")
	public String getInvoiceStatus() {
		return "invoiceStatus";
	}
	
	@GetMapping("/allInvoiceStatus")
	public List<InvoiceStatus>getAllInvoiceStatus(){
		List<InvoiceStatus> allInvoiceStatus = invoiceStatusService.getAllInvoiceStatus();
		return allInvoiceStatus;
	}
	
	@GetMapping("/getInvoiceStatus/{id}")
	public InvoiceStatus getById(@PathVariable int id) {
		InvoiceStatus byId = invoiceStatusService.getById(id);
		return byId;
	}
	
	@PostMapping("/createInvoiceStatus")
	public InvoiceStatus createInvoiceStatus(@RequestBody InvoiceStatus invoiceStatus) {
		InvoiceStatus createInvoiceStatus = invoiceStatusService.createInvoiceStatus(invoiceStatus);
		return createInvoiceStatus;
	}
	
	
	@PutMapping("/updateInvoiceStatus/{id}")
	public InvoiceStatus updateInvoiceStatus(@RequestBody InvoiceStatus invoiceStatus,@PathVariable int id) {
		InvoiceStatus updateInvoiceStatus = invoiceStatusService.updateInvoiceStatus(invoiceStatus, id);
		return updateInvoiceStatus;
	}
	
	@DeleteMapping("/deleteInvoiceStatus/{id}")
	public String deleteInvoiceStatusById(@PathVariable int id) {
		invoiceStatusService.deleteInvoiceStatusById(id);
		return ("Invoice status deleted successfully which id is "+id);
	}
	
	@DeleteMapping("/deleteAllInvoiceStatus")
	public String deleteAllInvoiceStatus() {
		invoiceStatusService.deleteAllInvoiceStatus();
		return "All invoice status are deleted";
	}


}
