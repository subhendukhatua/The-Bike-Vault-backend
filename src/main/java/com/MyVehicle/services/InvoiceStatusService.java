package com.MyVehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyVehicle.models.InvoiceStatus;
import com.MyVehicle.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//gett all invoice status 
	public List<InvoiceStatus>getAllInvoiceStatus(){
		List<InvoiceStatus> allInvoiceStatus = invoiceStatusRepository.findAll();
		return allInvoiceStatus;
		
	}
	
	//get invoice status By Id
	public InvoiceStatus getById(int id) {
		InvoiceStatus invoiceStatus = invoiceStatusRepository.findById(id).get();
		return invoiceStatus;
	}
	
	//create an invoice status
	public InvoiceStatus createInvoiceStatus(InvoiceStatus invoiceStatus) {
		InvoiceStatus newInvoiceStatus = invoiceStatusRepository.save(invoiceStatus);
		return newInvoiceStatus;
	}
	
	//update invoice status
	public InvoiceStatus updateInvoiceStatus(InvoiceStatus invoiceStatus,int id) {
		invoiceStatus.setId(invoiceStatus.getId());
		InvoiceStatus updatedInvoiceStatus = invoiceStatusRepository.save(invoiceStatus);
		return updatedInvoiceStatus;
	}
	
	//delete invoice status
	public void deleteInvoiceStatusById(int id) {
		invoiceStatusRepository.deleteById(id);
	}
	
	//delete all invoice status
	public void deleteAllInvoiceStatus() {
		invoiceStatusRepository.deleteAll();
	}

}
