package com.davi.finances.controllers;

import com.davi.finances.dtos.user.LoginDto;
import com.davi.finances.dtos.user.RegisterDto;
import com.davi.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody LoginDto userData){
        return userService.login(userData);
    }

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody RegisterDto userData){
        return userService.register(userData);
    }
}
