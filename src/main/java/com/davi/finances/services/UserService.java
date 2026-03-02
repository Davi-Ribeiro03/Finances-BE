package com.davi.finances.services;

import com.davi.finances.dtos.user.LoginDto;
import com.davi.finances.dtos.user.ResponseDto;
import com.davi.finances.dtos.user.RegisterDto;
import com.davi.finances.entities.User;
import com.davi.finances.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<ResponseDto> login(LoginDto userData) {
        User user = repository.getByEmail(userData.email());
        if(user != null && user.getPassword().equals(userData.password())){
            ResponseDto response = new ResponseDto(userData.email(), "Token 123");
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.status(401).build();
        }
    }

    public ResponseEntity<ResponseDto> register(RegisterDto userData) {
        User userIsRegistered = repository.getByEmail(userData.email());
        if(userIsRegistered != null){
            return ResponseEntity.badRequest().build();
        }
        User user = new User(userData.name(), userData.email(), userData.password());
        System.out.println(user);
        try {
            repository.save(user);
            return ResponseEntity.ok(new ResponseDto(userData.email(), "token 123"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
