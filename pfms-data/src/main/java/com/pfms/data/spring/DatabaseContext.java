package com.pfms.data.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.pfms.data.repository"})
public class DatabaseContext {

    private static final String[] entityPackages = {"com.pfms.data.transaction"};

    @Value("${PFMS_DB_TYPE}")
    private Database dbType;

    @Value("${PFMS_DB_DRIVER}")
    private String driverClassName;

    @Value("${PFMS_DB_URL}")
    private String url;

    @Value("${PFMS_DB_USERNAME}")
    private String username;

    @Value("${PFMS_DB_PASSWORD}")
    private String password;

    @Bean("pfmsDataSource")
    public DriverManagerDataSource getPfmsDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("jpaVendorAdapter")
    public JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(dbType);
        return jpaVendorAdapter;
    }

    @Bean("entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManagerFactoryBean.setDataSource(getPfmsDataSource());
        entityManagerFactoryBean.setPackagesToScan(entityPackages);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(getPfmsDataSource());
    }
}
