package com.pfms.service.endpoint;

import com.pfms.data.repository.TransactionRepository;
import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsService {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @RequestMapping("/transactions/client={clientId}")
    public List<Transaction> getTransactions(@PathVariable("clientId") String clientId) {
        return transactionRepository.findByClientId(clientId);
    }

    @RequestMapping("/transactions/type={type}")
    public List<Transaction> getTransactions(@PathVariable("type") TransactionType type) {
        return transactionRepository.findByType(type);
    }
}
