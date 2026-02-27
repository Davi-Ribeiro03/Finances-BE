package com.davi.finances.dtos.transaction;

import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

public record GetAllResponseDto(
        Long id, String title, BigDecimal value, Date date,
        String description, Categories categories, Date month_reference,
        transactionsType type, Long user_id) {
}
