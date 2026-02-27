package com.davi.finances.controllers;

import com.davi.finances.dtos.user.LoginDto;
import com.davi.finances.dtos.user.RegisterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<LoginDto> Login(@RequestBody LoginDto userData){
        return ResponseEntity.ok(userData);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> Login(@RequestBody RegisterDto userData){
        return ResponseEntity.ok(userData);
    }
}
