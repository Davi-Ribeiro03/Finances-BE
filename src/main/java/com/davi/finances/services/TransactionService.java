package com.davi.finances.services;

import com.davi.finances.dtos.transaction.TransactionDto;
import com.davi.finances.entities.Transaction;
import com.davi.finances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tRepo;

    public ResponseEntity<List<TransactionDto>> GetAll(LocalDate monthReference) {
        List<Transaction> transactions = tRepo.findAllByMonthReference(monthReference);

        List<TransactionDto> response = transactions.stream()
                .map(TransactionDto::fromEntity)
                .toList();

        return ResponseEntity.ok(response);
    }
}
