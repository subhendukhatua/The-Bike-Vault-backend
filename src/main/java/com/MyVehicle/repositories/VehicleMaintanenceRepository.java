package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.MyVehicle.models.VehicleMaintenance;

@Repository
public interface VehicleMaintanenceRepository extends JpaRepository<VehicleMaintenance, Integer>{
	

}
