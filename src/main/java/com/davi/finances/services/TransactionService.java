package com.davi.finances.services;

import com.davi.finances.dtos.transaction.TransactionDto;
import com.davi.finances.entities.Transaction;
import com.davi.finances.entities.User;
import com.davi.finances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity Add(TransactionDto transactionData) {
        User user = new User();
        user.setId(transactionData.userId());

        Transaction transaction = new Transaction(
                transactionData.title(),
                transactionData.value(),
                transactionData.date(),
                transactionData.description(),
                transactionData.category(),
                transactionData.monthReference(),
                transactionData.type(),
                user
        );

        try {
            tRepo.save(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).body(transactionData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
