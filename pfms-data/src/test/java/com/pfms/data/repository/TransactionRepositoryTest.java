package com.pfms.data.repository;

import com.pfms.data.spring.DatabaseContext;
import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;
import org.cassandraunit.spring.CassandraDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@PfmsTestRepository
@SpringJUnitConfig(classes = {DatabaseContext.class})
@CassandraDataSet(value = "com/pfms/data/repository/transaction-data.cql", keyspace = "pfms")
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

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
