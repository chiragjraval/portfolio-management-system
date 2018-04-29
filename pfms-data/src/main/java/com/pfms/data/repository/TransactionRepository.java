package com.pfms.data.repository;

import com.pfms.data.transaction.Transaction;
import com.pfms.data.transaction.TransactionType;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, Integer> {

    @AllowFiltering
    List<Transaction> findByClientId(String clientId);

    @AllowFiltering
    List<Transaction> findByType(TransactionType type);

}
