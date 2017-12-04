package com.pfms.data.spring;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Log4jConfigurer;

@SuppressWarnings("deprecation")
@Configuration
public class LogbackContext {

	@Bean(name="log4jInitializer")
	public boolean getLog4jInitializer() throws FileNotFoundException {
		Log4jConfigurer.initLogging("classpath:com/pfms/config/logback/logback-config.xml");
		return true;
	}
	
}
