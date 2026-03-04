package com.davi.finances.repositories;

import com.davi.finances.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByMonthReference(Date monthReference);

}
