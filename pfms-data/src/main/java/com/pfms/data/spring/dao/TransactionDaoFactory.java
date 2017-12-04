package com.pfms.data.spring.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pfms.dao.transaction.TransactionDao;

@Configuration
public class TransactionDaoFactory {

	@Autowired
	private SqlSessionFactoryBean pfmsSqlSessionFactory;
	
	@Bean(name="transactionDao")
	public MapperFactoryBean<TransactionDao> getTransactionDao() throws Exception {
		MapperFactoryBean<TransactionDao> transactionDao = new MapperFactoryBean<TransactionDao>(TransactionDao.class);
		transactionDao.setSqlSessionFactory(pfmsSqlSessionFactory.getObject());
		return transactionDao;
	}
	
}
