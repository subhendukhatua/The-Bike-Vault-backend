package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.MyVehicle.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	

}
