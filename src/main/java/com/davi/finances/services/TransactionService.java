package com.davi.finances.services;

import com.davi.finances.dtos.transaction.TransactionDto;
import com.davi.finances.dtos.transaction.TransactionsWithStatistics;
import com.davi.finances.entities.Transaction;
import com.davi.finances.entities.User;
import com.davi.finances.enums.transactionsType;
import com.davi.finances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tRepo;

    public TransactionsWithStatistics GetAll(LocalDate monthReference) {
        List<Transaction> transactions = tRepo.findAllByMonthReference(monthReference);
        List<TransactionDto> transactionsDto = new ArrayList<>();
        BigDecimal totalEntries = BigDecimal.ZERO;
        BigDecimal totalExpenses = BigDecimal.ZERO;

        for (Transaction t : transactions) {
            transactionsDto.add(TransactionDto.fromEntity(t));

            if (t.getType() == transactionsType.entry) {
                totalEntries = totalEntries.add(t.getValue());
            } else if (t.getType() == transactionsType.expense) {
                totalExpenses = totalExpenses.add(t.getValue());
            }
        }

        BigDecimal balance = totalEntries.subtract(totalExpenses);

        return new TransactionsWithStatistics(balance, totalEntries, totalExpenses, transactionsDto);
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
