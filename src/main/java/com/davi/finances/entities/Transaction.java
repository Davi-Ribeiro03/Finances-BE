package com.davi.finances.entities;

import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "transaction")
@Entity(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private BigDecimal value;
    private Date date;
    private String description;
    private Categories category;
    private String month_reference;
    @Enumerated(EnumType.STRING)
    private transactionsType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
