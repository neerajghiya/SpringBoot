package com.metacube.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.stereotype.Service;

import com.metacube.springboot.gemFireRepo.VINRepository;
import com.metacube.springboot.gemFireRepo.VMIRepository;
import com.metacube.springboot.model.HeaderVMI;
import com.metacube.springboot.model.VinData;

@Service
@EnableGemfireRepositories(basePackageClasses=VMIRepository.class)
public class VMIService {
	private static final Logger logger = LoggerFactory.getLogger(VMIService.class);
	
	@Autowired 
	VMIRepository vmiRepository;
	
	@Autowired 
	VINRepository vinRepository;
	
	public HeaderVMI getVMIData(String vin){
		logger.debug("Inside  getVMIData");
		HeaderVMI returnObject = null;
		
		returnObject = vmiRepository.findVMIDetailsByVin(vin);
		logger.debug(" vmi data ==  " +returnObject);
		if(returnObject == null){
			returnObject = getVMI(vin);
			vmiRepository.save(returnObject); // saved into gemfire
		}
		
		return returnObject;
	}
	
	public VinData getVINData(String vin){
		logger.debug("Inside  getVINData");
		VinData returnObject = null;
		
		returnObject = vinRepository.findVINDetailsByVinOld(vin);
		logger.debug(" vmi data ==  " +returnObject);
		if(returnObject == null){
			returnObject = getVIN(vin);
			vinRepository.save(returnObject); // saved into gemfire
		}
		
		return returnObject;
	}
	
	private HeaderVMI getVMI(String vin) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Get VMI data");
		HeaderVMI headerVMI = new HeaderVMI();
		headerVMI.setCampCount("456");
		headerVMI.setDlvyDate("14/05/2017");
		headerVMI.setDlvyType("dlvyT");
		headerVMI.setEngineNo("456");
		headerVMI.setFin("fin");
		headerVMI.setHistCount("5");
		headerVMI.setInvDealer("Test");
		headerVMI.setNoOfLine("6");
		headerVMI.setOwner("mbusa");
		headerVMI.setVin(vin);
		return headerVMI;
	}
	
	private VinData getVIN(String vin) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Get VMI data");
		VinData vinData = new VinData();
		vinData.setFin("feather");
		vinData.setVinOld(vin);
		vinData.setLocation("Mercedes");
		return vinData;
	}
}
