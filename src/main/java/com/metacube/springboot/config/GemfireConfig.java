package com.metacube.springboot.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemstone.gemfire.cache.GemFireCache;
import com.metacube.springboot.model.HeaderVMI;

@Configuration
public class GemfireConfig {
	private static final Logger logger = LoggerFactory.getLogger(GemfireConfig.class);
	
	 @Bean
		Properties gemfireProperties() {
	    	logger.debug("gemfireProperties");
			Properties gemfireProperties = new Properties();
			gemfireProperties.setProperty("name", "DataGemFireRestApplication");
			gemfireProperties.setProperty("mcast-port", "0");
			gemfireProperties.setProperty("log-level", "config");
			return gemfireProperties;
		}

		@Bean
		CacheFactoryBean gemfireCache() {
			logger.debug("gemfireCache");
			CacheFactoryBean gemfireCache = new CacheFactoryBean();
			gemfireCache.setClose(true);
			gemfireCache.setProperties(gemfireProperties());
			return gemfireCache;
		}

		@Bean
		LocalRegionFactoryBean<String, HeaderVMI> helloRegion(GemFireCache cache) {
			LocalRegionFactoryBean<String, HeaderVMI> vmiRegion = new LocalRegionFactoryBean<>();
			vmiRegion.setCache(cache);
			vmiRegion.setClose(false);
			vmiRegion.setName("VMI");
			vmiRegion.setPersistent(false);
			return vmiRegion;
		}

}
