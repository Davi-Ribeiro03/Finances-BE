package com.davi.finances.controllers;

import com.davi.finances.configs.ApiResponse;
import com.davi.finances.dtos.user.LoginUserDto;
import com.davi.finances.dtos.user.RegisterUserDto;
import com.davi.finances.dtos.user.ResponseUserDto;
import com.davi.finances.entities.User;
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
    public ResponseEntity<ApiResponse> Login(@RequestBody LoginUserDto userData){
        try {
            User user = userService.login(userData);

            ApiResponse<ResponseUserDto> response = ApiResponse.success(
                    "successful login",
                    new ResponseUserDto(user.getName(), user.getEmail(), "Token 123")
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<Object> responseError = ApiResponse.error(e.getMessage());
            return ResponseEntity.badRequest().body(responseError);
        }

    }

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody RegisterUserDto userData){
        try {
            User user = userService.register(userData);
            ApiResponse<ResponseUserDto> response = ApiResponse.success(
                    "User successfully registered",
                    new ResponseUserDto(user.getName(), user.getEmail(), "Token123")
            );

            return ResponseEntity.ok().body(response);
        } catch (RuntimeException e) {
            ApiResponse<Object> error = ApiResponse.error(e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }
    }
}
