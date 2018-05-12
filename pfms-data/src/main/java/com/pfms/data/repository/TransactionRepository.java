package com.pfms.data.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, Integer> {

    @AllowFiltering
    List<Transaction> findByClientId(String clientId);

    @AllowFiltering
    List<Transaction> findByType(TransactionType type);

}
