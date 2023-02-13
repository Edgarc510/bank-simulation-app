package com.bank.repository;

import com.bank.dto.TransactionDTO;
import com.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    //Native query
    @Query(value = "SELECT * FROM transactions ORDER BY creation_date DESC LIMIT 10", nativeQuery = true)
    List<Transaction> findLastTenTransaction();

    //JPQL Query
    @Query("SELECT t FROM Transactions t where t.sender.id = ?1 OR t.receiver.id = ?1")
    List<Transaction> findTransactionListById(Long id);

}
