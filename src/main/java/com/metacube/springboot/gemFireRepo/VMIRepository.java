package com.metacube.springboot.gemFireRepo;

import org.springframework.data.repository.CrudRepository;

import com.metacube.springboot.model.HeaderVMI;

public interface VMIRepository extends CrudRepository<HeaderVMI, String> {
	
	public HeaderVMI findVMIDetailsByVin(String vin);

}
