package com.metacube.springboot.gemFireRepo;

import org.springframework.data.repository.CrudRepository;

import com.metacube.springboot.model.VinData;

public interface VINRepository extends CrudRepository<VinData, String> {
	
	public VinData findVINDetailsByVinOld(String vinOld);

}
