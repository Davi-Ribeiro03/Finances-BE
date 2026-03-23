package com.davi.finances.dtos.transaction;

import java.math.BigDecimal;
import java.util.List;

public record TransactionsWithStatistics(BigDecimal balance, BigDecimal totalEntry, BigDecimal totalExpense, List<TransactionDto> transactions ) {
}
