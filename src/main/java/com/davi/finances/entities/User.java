package com.davi.finances.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Entity(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "users")
    private List<Transaction> transactionList;

}
