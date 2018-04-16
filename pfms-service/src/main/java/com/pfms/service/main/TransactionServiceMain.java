package com.pfms.service.main;

import com.pfms.data.spring.DatabaseContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.pfms.service.endpoint"})
@PropertySource({"classpath:com/pfms/config/properties/${ENV}/${ENV}.properties"})
@Import({DatabaseContext.class})
public class TransactionServiceMain {

    private static final Logger LOGGER = LogManager.getLogger(TransactionServiceMain.class);

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceMain.class, args);
        LOGGER.info("Hurrah!!! Server started!!!");
    }

}
