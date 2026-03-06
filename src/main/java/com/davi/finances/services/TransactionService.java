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
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tRepo;

    public List<Transaction> GetAll(LocalDate monthReference) {
        return tRepo.findAllByMonthReference(monthReference);
    }

    public Transaction Add(TransactionDto transactionData) {
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

        return tRepo.save(transaction);

    }

    public Transaction Edit(TransactionDto transactionData) {
        tRepo.deleteById(transactionData.id());
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

        return tRepo.save(transaction);
    }

    public void Delete(Long id) {
        tRepo.deleteById(id);
    }
}
