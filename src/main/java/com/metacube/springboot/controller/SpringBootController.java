package com.metacube.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.springboot.model.HeaderVMI;
import com.metacube.springboot.service.VMIService;

@RestController
public class SpringBootController {
	
	@Autowired
	private VMIService vmiService;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootController.class);
    @RequestMapping("/test")
    public String index() {
    	logger.debug("Inside Index");
        return "Successfully launched SpringBoot Application through REST URL!";
    }
    
    @RequestMapping(value = "/vmi", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public Object getVMIData(@RequestParam("vin") String vin) throws Exception {

		logger.debug("VMIController >> getDealer/{dealerId}");


		HeaderVMI returnObject = vmiService.getVMIData(vin);
		
		logger.info("Result ====" + returnObject.toString());

		return returnObject;

	}

	
    
}
