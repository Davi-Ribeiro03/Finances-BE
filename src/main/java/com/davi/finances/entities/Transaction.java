package com.davi.finances.entities;

import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "transactions")
@Entity(name="transactions")
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal value;
    private Date date;
    private String description;
    private Categories category;
    @Column(name = "month_reference")
    private Date monthReference;
    @Enumerated(EnumType.STRING)
    private transactionsType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
