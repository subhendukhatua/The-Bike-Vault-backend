package com.MyVehicle.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyVehicle.models.Invoice;
import com.MyVehicle.services.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/invoice")
	public String getInvoice() {
		return "invoice";
	}
	
	
	@GetMapping("/getAllInvoices")
	public List<Invoice>getAllInvoices(){
		List<Invoice> allInvoices = invoiceService.getAllInvoices();
		return allInvoices;
	}
	
	
	@GetMapping("/getInvoice/{id}")
	public Invoice getInvoiceById(@PathVariable  int id) {
		Invoice byId = invoiceService.getById(id);
		return byId;
	}
	
	
	@PostMapping("/createInvoice")
	public Invoice createInvoice(@RequestBody Invoice invoice) {
		Invoice newInvoice = invoiceService.newInvoice(invoice);
		return newInvoice;
	}
	
	@PutMapping("/updateInvoice/{id}")
	public Invoice updateInvoice(@RequestBody Invoice invoice,@PathVariable int id) {
		Invoice updatedInvoice = invoiceService.updateInvoice(invoice, id);
		return updatedInvoice;
	}
	
	@DeleteMapping("/deleteInvoice/{id}")
	public String deleteInvoice(@PathVariable int id) {
		invoiceService.deleteById(id);
		return ("Invoice are deleted successfully whose id is "+id);
	}
	
	
	public String deleteAllInvoice() {
		invoiceService.deleteAll();
		return "All invoices are deleted";
		
	}
	


}
