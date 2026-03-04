package com.davi.finances.dtos.transaction;

import com.davi.finances.entities.Transaction;
import com.davi.finances.entities.User;
import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;

import java.math.BigDecimal;
import java.util.Date;

public record TransactionDto(
        Long id, String title, BigDecimal value, Date date,
        String description, Categories categories, Date monthReference,
        transactionsType type, User user) {

    public static TransactionDto fromEntity(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getTitle(),
                transaction.getValue(),
                transaction.getDate(),
                transaction.getDescription(),
                transaction.getCategory(),
                transaction.getMonthReference(),
                transaction.getType(),
                transaction.getUser()
        );
    }
}
