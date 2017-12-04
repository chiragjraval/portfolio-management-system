package com.pfms.data.spring.dbtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.pfms.data.spring.DatabaseContext;
import com.pfms.data.spring.dao.TransactionDaoFactory;

@Configuration
@PropertySource({"classpath:com/pfms/config/properties/${ENV}/${ENV}.properties"})
@Import({DatabaseContext.class, TransactionDaoFactory.class})
public class DatabaseTestContext {

}
