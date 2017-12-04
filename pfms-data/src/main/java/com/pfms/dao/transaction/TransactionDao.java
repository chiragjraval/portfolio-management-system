package com.pfms.dao.transaction;

import java.util.List;

import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;

public interface TransactionDao {
	public List<Transaction> getAllTransactions();

	public List<Transaction> getAllTransactionsForClient(String clientId);

	public List<Transaction> getAllTransactionsForType(TransactionType type);
}
