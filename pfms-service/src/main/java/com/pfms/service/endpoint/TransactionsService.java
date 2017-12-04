package com.pfms.service.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfms.dao.transaction.TransactionDao;
import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;

@RestController
public class TransactionsService {

	@Autowired
	private TransactionDao transactionDao;
	
	@RequestMapping("/transactions")
	public List<Transaction> getTransactions() {
		return transactionDao.getAllTransactions();
	}
	
	@RequestMapping("/transactions/client={clientId}")
	public List<Transaction> getTransactions(@PathVariable("clientId") String clientId) {
		return transactionDao.getAllTransactionsForClient(clientId);
	}
	
	@RequestMapping("/transactions/type={type}")
	public List<Transaction> getTransactions(@PathVariable("type") TransactionType type) {
		return transactionDao.getAllTransactionsForType(type);
	}
}
