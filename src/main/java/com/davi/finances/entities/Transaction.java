package com.davi.finances.entities;

import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "transactions")
@Entity(name="transactions")
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate monthReference;
    @Enumerated(EnumType.STRING)
    private transactionsType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction(String title, BigDecimal value, Date date, String description, Categories category,
                       LocalDate monthReference, transactionsType type, User user){
        this.title = title;
        this.value = value;
        this.date = date;
        this.description = description;
        this.category = category;
        this.monthReference = monthReference;
        this.type = type;
        this.user = user;

    }

}
