package com.freebird.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.freebird.aspect.ExceptionLoggerAspect;
import com.freebird.aspect.PerformanceLogForServiceDAOAspect;

/**
 * Include all the configuration needed for application in this file
 * Also properties file of Java project should be included in this file
 */
@Configuration
@PropertySource(value={"classpath:config/environment-${env}.properties",
					   "classpath:config/sample-${env}.properties"
					  })
@ComponentScan(basePackages={"com.freebird.web.service",
							  "com.freebird.web.jms",
							  "com.freebird.web.async",
							  "com.freebird.web.dao.file",
							  "com.freebird.web.dao.memory",
							  "com.freebird.web.dao.helper"
							})
@Import(value={PersistenceJpaConfig.class,
		       EhCacheConfig.class
		       })
@EnableAspectJAutoProxy
public class CommonBeansConfig{

	/**
	 * Aspect for performance logging
	 *
	 */
	@Bean
	public PerformanceLogForServiceDAOAspect iafPerformanceLogAspect(){
		PerformanceLogForServiceDAOAspect iafPerformanceLogForServiceAspect = new PerformanceLogForServiceDAOAspect();
		return iafPerformanceLogForServiceAspect;

	}

	/**
	 * Aspect for logging parameter values, if RuntimeException is raised from service or dao layer
	 */
	/*@Bean
	public ParamInfoExceptionAspect paramInfoExceptionAspect(){
		ParamInfoExceptionAspect paramInfoExceptionAspect = new ParamInfoExceptionAspect();
		return paramInfoExceptionAspect;

	}*/
	
	/**
	 * Aspect for logging parameter values & exception stack trace, if RuntimeException is raised from service or dao layer
	 */
	@Bean
	public ExceptionLoggerAspect exceptionLoggerAspect(){
		ExceptionLoggerAspect exceptionLoggerAspect = new ExceptionLoggerAspect();
		return exceptionLoggerAspect;

	}
}