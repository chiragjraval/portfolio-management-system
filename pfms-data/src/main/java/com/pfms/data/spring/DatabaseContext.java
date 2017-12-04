package com.pfms.data.spring;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseContext {

	@Value("${PFMS_DB_DRIVER}")
	private String driverClassName;
	
	@Value("${PFMS_DB_URL}")
	private String url;
	
	@Value("${PFMS_DB_USERNAME}")
	private String username;
	
	@Value("${PFMS_DB_PASSWORD}")
	private String password;
	
	@Bean(name="pfmsDataSource")
	public DriverManagerDataSource getPfmsDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean(name="pfmsSqlSessionFactory")
	public SqlSessionFactoryBean getPfmsSqlSessionFactory() {
		ClassPathResource classPathResource = new ClassPathResource("com/pfms/data/mybatis/mybatis-config.xml");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getPfmsDataSource());
		sqlSessionFactoryBean.setConfigLocation(classPathResource);
		return sqlSessionFactoryBean;
	}
	
	@Bean(name="transactionManager")
	public DataSourceTransactionManager getTransactionManager(){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(getPfmsDataSource());
		return transactionManager;
	}
}
