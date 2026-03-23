package com.davi.finances.services;

import com.davi.finances.dtos.user.LoginUserDto;
import com.davi.finances.dtos.user.RegisterUserDto;
import com.davi.finances.entities.User;
import com.davi.finances.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User login(LoginUserDto userData) {
        User user = repository.getByEmail(userData.email());
        if(user == null || !user.getPassword().equals(userData.password())){
            throw new RuntimeException("Login error");
        }

        return user;
    }

    public User register(RegisterUserDto userData) {
        User userIsRegistered = repository.getByEmail(userData.email());

        if(userIsRegistered != null){
            throw new RuntimeException("User already registered");
        }

        try {
            User user = new User(userData.name(), userData.email(), userData.password());
            return repository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("internal error");
        }
    }
}
