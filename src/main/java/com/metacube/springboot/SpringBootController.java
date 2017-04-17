package com.metacube.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpringBootController {
    
	private static final Logger logger = LoggerFactory.getLogger(SpringBootController.class);
    @RequestMapping("/test")
    public String index() {
    	logger.debug("Inside Index");
        return "Successfully launched SpringBoot Application through REST URL!";
    }
    
}
