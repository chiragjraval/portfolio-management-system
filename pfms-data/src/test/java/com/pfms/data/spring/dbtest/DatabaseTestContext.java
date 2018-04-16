package com.pfms.data.spring.dbtest;

import com.pfms.data.spring.DatabaseContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:com/pfms/config/properties/${ENV}/${ENV}.properties"})
@Import({DatabaseContext.class})
public class DatabaseTestContext {

}
