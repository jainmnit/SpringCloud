package com.now.eai.scsp.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import com.now.eai.scsp.model.Dealers;



//@Configuration
public class GemfireConfig {
	private static final Logger logger = LoggerFactory.getLogger(GemfireConfig.class);
	
	/* @Bean
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
		LocalRegionFactoryBean<String, Dealers> dealerRegion(GemFireCache cache) {
			LocalRegionFactoryBean<String, Dealers> dealerRegion = new LocalRegionFactoryBean<>();
			dealerRegion.setCache(cache);
			dealerRegion.setClose(false);
			dealerRegion.setName("DEALER");
			dealerRegion.setPersistent(false);
			return dealerRegion;
		}
		
*/		

}
