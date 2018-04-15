package com.pfms.dao.transaction;

import java.text.ParseException;
import java.util.List;

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

import com.pfms.data.spring.dbtest.DatabaseTestContext;
import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;

@ContextConfiguration(classes = {DatabaseTestContext.class})
@TestPropertySource(properties = {"ENV=test"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionDaoTest {

	private static boolean isSetupDone = false;

	@Autowired
	public DriverManagerDataSource pfmsDataSource;

	@Autowired
	public TransactionDao transactionDao;

	@Before
	public void setUp() throws Exception {
		if (!isSetupDone) {
			ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
			databasePopulator.addScript(new ClassPathResource("com/pfms/dao/transaction/create-table.sql"));
			databasePopulator.addScript(new ClassPathResource("com/pfms/dao/transaction/insert-data.sql"));
			DatabasePopulatorUtils.execute(databasePopulator, pfmsDataSource);
			isSetupDone = true;
		}
	}

	@Test
	public void testGetAllTransactions() throws ParseException {
		List<Transaction> transactions = transactionDao.getAllTransactions();
		Assert.assertTrue(transactions.size() == 10);
	}

	@Test
	public void testGetAllTransactionsForClient() throws ParseException {
		List<Transaction> transactions = transactionDao.getAllTransactionsForClient("NIKUNJ");
		Assert.assertTrue(transactions.size() == 4);

		transactions = transactionDao.getAllTransactionsForClient("CHIRAG");
		Assert.assertTrue(transactions.size() == 3);
	}

	@Test
	public void testGetAllTransactionsForType() throws ParseException {
		List<Transaction> transactions = transactionDao.getAllTransactionsForType(TransactionType.BUY);
		Assert.assertTrue(transactions.size() == 6);

		transactions = transactionDao.getAllTransactionsForType(TransactionType.SELL);
		Assert.assertTrue(transactions.size() == 4);
	}

}
