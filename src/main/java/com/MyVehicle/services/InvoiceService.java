package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.Invoice;
import com.MyVehicle.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	//get all invoices
	public List<Invoice> getAllInvoices(){
		List<Invoice> getAllInvoices = invoiceRepository.findAll();
		return getAllInvoices;
	}
	
	 //get invoice by Id
	public Invoice getById(int id) {
		Invoice invoice = invoiceRepository.findById(id).get();
		return invoice;
	}
	
	//create new invoice
	public Invoice newInvoice(Invoice invoice) {
		Invoice newInvoice = invoiceRepository.save(invoice);
		return newInvoice;
	}
	
	//update an invoice
	public Invoice updateInvoice(Invoice invoice,int id) {
		invoice.setId(invoice.getId());
		Invoice updateInvoice = invoiceRepository.save(invoice);
		return updateInvoice;
	}
	
	
	//delete invoice by id
	public void deleteById(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//delete all invoices
	public void deleteAll () {
		invoiceRepository.deleteAll();
	}

}
