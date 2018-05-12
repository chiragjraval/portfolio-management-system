package com.pfms.service.endpoint;

import java.util.List;

import org.cassandraunit.spring.CassandraDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pfms.data.repository.PfmsTestRepository;
import com.pfms.data.spring.DatabaseContext;
import com.pfms.data.transaction.Transaction;

@RunWith(SpringRunner.class)
@PfmsTestRepository
@EnableAutoConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DatabaseContext.class, TransactionsService.class}
)
@CassandraDataSet(value = "com/pfms/data/repository/transaction-data.cql", keyspace = "pfms")
public class TransactionServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void nonNullRestTemplate() {
        Assert.assertNotNull(restTemplate);
    }

    @Test
    public void testGetAllTransactions() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/transactions", List.class);
        List<Transaction> transactions = responseEntity.getBody();
        Assert.assertEquals(10, transactions.size());
    }

    @Test
    public void testGetAllTransactionsForClient() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/transactions/client=NIKUNJ", List.class);
        List<Transaction> transactions = responseEntity.getBody();
        Assert.assertEquals(4, transactions.size());

        responseEntity = restTemplate.getForEntity("/transactions/client=CHIRAG", List.class);
        transactions = responseEntity.getBody();
        Assert.assertEquals(3, transactions.size());
    }

    @Test
    public void testGetAllTransactionsForType() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/transactions/type=BUY", List.class);
        List<Transaction> transactions = responseEntity.getBody();
        Assert.assertEquals(6, transactions.size());

        responseEntity = restTemplate.getForEntity("/transactions/type=SELL", List.class);
        transactions = responseEntity.getBody();
        Assert.assertEquals(4, transactions.size());
    }

}
