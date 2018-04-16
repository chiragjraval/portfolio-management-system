package com.pfms.data.repository;

import com.pfms.data.spring.dbtest.DatabaseTestContext;
import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = {DatabaseTestContext.class})
@TestPropertySource(properties = {"ENV=test"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionRepositoryTest {

    @Autowired
    private DriverManagerDataSource pfmsDataSource;

    @Autowired
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("com/pfms/data/repository/insert-data.sql"));
        DatabasePopulatorUtils.execute(databasePopulator, pfmsDataSource);
    }

    @Test
    public void testGetAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        Assert.assertEquals(10, transactions.size());
    }

    @Test
    public void testGetAllTransactionsForClient() {
        List<Transaction> transactions = transactionRepository.findByClientId("NIKUNJ");
        Assert.assertEquals(4, transactions.size());

        transactions = transactionRepository.findByClientId("CHIRAG");
        Assert.assertEquals(3, transactions.size());
    }


    @Test
    public void testGetAllTransactionsForType() {
        List<Transaction> transactions = transactionRepository.findByType(TransactionType.BUY);
        Assert.assertEquals(6, transactions.size());

        transactions = transactionRepository.findByType(TransactionType.SELL);
        Assert.assertEquals(4, transactions.size());
    }

}
