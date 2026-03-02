package com.davi.finances.repositories;

import com.davi.finances.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
