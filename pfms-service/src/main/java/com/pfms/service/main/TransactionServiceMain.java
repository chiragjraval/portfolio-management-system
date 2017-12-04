package com.pfms.service.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.pfms.data.spring.DatabaseContext;
import com.pfms.data.spring.dao.TransactionDaoFactory;

@SpringBootApplication(scanBasePackages={"com.pfms.service.endpoint"})
@PropertySource({"classpath:com/pfms/config/properties/${ENV}/${ENV}.properties"})
@Import({DatabaseContext.class, TransactionDaoFactory.class})
public class TransactionServiceMain {

	private static final Logger LOGGER = LogManager.getLogger(TransactionServiceMain.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceMain.class, args);
		LOGGER.info("Hurrah!!! Server started!!!");
	}
	
}
