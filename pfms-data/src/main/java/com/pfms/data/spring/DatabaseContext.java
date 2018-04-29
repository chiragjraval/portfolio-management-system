package com.pfms.data.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableCassandraRepositories(basePackages = {"com.pfms.data.repository"})
public class DatabaseContext extends AbstractCassandraConfiguration {

    @Value("${pfms.cassandra.contactPoints}")
    private String contactPoints;

    @Value("${pfms.cassandra.port}")
    private int port;

    @Value("${pfms.cassandra.keyspace.name}")
    private String keyspaceName;

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

}