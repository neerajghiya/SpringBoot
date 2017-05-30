package com.metacube.springboot.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.ExpirationActionType;
import org.springframework.data.gemfire.ExpirationAttributesFactoryBean;
import org.springframework.data.gemfire.PartitionedRegionFactoryBean;
import org.springframework.data.gemfire.RegionAttributesFactoryBean;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.DataPolicy;
import com.gemstone.gemfire.cache.ExpirationAttributes;
import com.gemstone.gemfire.cache.RegionAttributes;
import com.gemstone.gemfire.management.internal.cli.util.JsonUtil.Employee;

@Configuration
public class GemfireConfig {
	private static final Logger logger = LoggerFactory.getLogger(GemfireConfig.class);
	
	 @Bean
		Properties gemfireProperties() {
	    	logger.debug("gemfireProperties");
			Properties gemfireProperties = new Properties();
			//gemfireProperties.setProperty("locators", "localhost[11235]");
			//gemfireProperties.setProperty("start-locator", "localhost[11235]");
			//gemfireProperties.setProperty("name", "DataGemFireRestApplication");
			gemfireProperties.setProperty("mcast-port", "2");
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

		/*@Bean
		LocalRegionFactoryBean<String, HeaderVMI> helloRegion(GemFireCache cache) {
			LocalRegionFactoryBean<String, HeaderVMI> vmiRegion = new LocalRegionFactoryBean<>();
			vmiRegion.setCache(cache);
			vmiRegion.setClose(false);
			vmiRegion.setName("VMI");
			vmiRegion.setPersistent(false);
			return vmiRegion;
		}*/
		
		/*@Bean
		@Autowired
		public LocalRegionFactoryBean<String, Employee> examplePartitionRegion(Cache gemfireCache,
				@Qualifier("logicalRegionAttributes") RegionAttributes<String, Employee> regionAttributes) throws Exception {

			 LocalRegionFactoryBean<String, Employee> examplePartitionRegion = new LocalRegionFactoryBean<String, Employee>();
			examplePartitionRegion.setAttributes(regionAttributes);
			examplePartitionRegion.setClose(false);
			examplePartitionRegion.setCache(gemfireCache);
			examplePartitionRegion.setName("VMI");
			examplePartitionRegion.setPersistent(false);
			examplePartitionRegion.setDataPolicy(DataPolicy.REPLICATE);

			return examplePartitionRegion;
		}*/
		
		
		@Bean
		@Autowired
		public PartitionedRegionFactoryBean<String, Employee> examplePartitionRegion(Cache gemfireCache,
				@Qualifier("partitionRegionAttributes") RegionAttributes<String, Employee> regionAttributes) throws Exception {

			PartitionedRegionFactoryBean<String, Employee> examplePartitionRegion = new PartitionedRegionFactoryBean<String, Employee>();
			examplePartitionRegion.setAttributes(regionAttributes);
			examplePartitionRegion.setClose(false);
			examplePartitionRegion.setCache(gemfireCache);
			examplePartitionRegion.setName("VMI");
			examplePartitionRegion.setPersistent(false);
			examplePartitionRegion.setDataPolicy(DataPolicy.PARTITION);

			return examplePartitionRegion;
		}
		
		@Bean
		@Autowired
		public RegionAttributesFactoryBean partitionRegionAttributes(
				@Qualifier("entryTtiExpirationAttributes") ExpirationAttributes entryTti,
				@Qualifier("entryTtlExpirationAttributes") ExpirationAttributes entryTtl) {

			RegionAttributesFactoryBean regionAttributes = new RegionAttributesFactoryBean();
			//regionAttributes.setScope(Scope.DISTRIBUTED_ACK);
			//regionAttributes.setEvictionAttributes(evictionAttributes);
			regionAttributes.setEntryIdleTimeout(entryTti);
			regionAttributes.setEntryTimeToLive(entryTtl);
			//regionAttributes.setlog(partitionAttributes);

			return regionAttributes;
		}
		
		@Bean
		@Autowired
		public RegionAttributesFactoryBean logicalRegionAttributes(
				@Qualifier("entryTtiExpirationAttributes") ExpirationAttributes entryTti,
				@Qualifier("entryTtlExpirationAttributes") ExpirationAttributes entryTtl) {

			RegionAttributesFactoryBean regionAttributes = new RegionAttributesFactoryBean();
			//regionAttributes.setEvictionAttributes(evictionAttributes);
			regionAttributes.setEntryIdleTimeout(entryTti);
			regionAttributes.setEntryTimeToLive(entryTtl);
			//regionAttributes.setlog(partitionAttributes);

			return regionAttributes;
		}
		
		@Bean
		public ExpirationAttributesFactoryBean entryTtiExpirationAttributes() {

			ExpirationAttributesFactoryBean expirationAttributes = new ExpirationAttributesFactoryBean();

			expirationAttributes.setAction(ExpirationActionType.valueOfIgnoreCase("INVALIDATE").getExpirationAction());
			expirationAttributes.setTimeout(500);

			return expirationAttributes;
		}

		@Bean
		public ExpirationAttributesFactoryBean entryTtlExpirationAttributes() {

			ExpirationAttributesFactoryBean expirationAttributes = new ExpirationAttributesFactoryBean();
			System.out.println("Comes here in Expriation time");
			expirationAttributes.setAction(ExpirationActionType.valueOfIgnoreCase("INVALIDATE").getExpirationAction());
			expirationAttributes.setTimeout(500);

			return expirationAttributes;
		}
		
		/*@Bean
		LocalRegionFactoryBean<String, VinData> vinRegion(GemFireCache cache) {
			LocalRegionFactoryBean<String, VinData> vmiRegion = new LocalRegionFactoryBean<>();
			vmiRegion.setCache(cache);
			vmiRegion.setClose(false);
			vmiRegion.setName("VMI");
			vmiRegion.setPersistent(false);
			return vmiRegion;
		}*/

}
