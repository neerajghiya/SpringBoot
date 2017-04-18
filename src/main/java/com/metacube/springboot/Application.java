package com.metacube.springboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.metacube.springboot.gemFireRepo.VMIRepository;

/*@SpringBootApplication is a convenience annotation that adds all of the following:

 @Configuration tags the class as a source of bean definitions for the application context.

 @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, 
 other beans, and various property settings.

 Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically
 when it sees spring-webmvc on the classpath. This flags the application as a web application and 
 activates key behaviors such as setting up a DispatcherServlet.
 
 @ComponentScan tells Spring to look for other components, configurations, and services in the 
 com.metacube.springboot package, allowing it to find the controllers.
 
 The main() method uses Spring Boot SpringApplication.run() method to launch an application.*/

@SpringBootApplication
@EnableGemfireRepositories
@EnableCaching
public class Application {
	
	/*By default, SLF4j Logging is included in the Spring Boot web application, 
	 * you just need to enable it. To enable logging, create a application.properties 
	 * file in the root of the resources folder.*/
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        logger.debug("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	logger.debug(beanName);
        }
    }
    
   

}
