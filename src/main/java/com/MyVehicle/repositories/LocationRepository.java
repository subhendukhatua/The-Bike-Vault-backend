package com.MyVehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.MyVehicle.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	

}
