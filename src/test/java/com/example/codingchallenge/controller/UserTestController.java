package com.example.codingchallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {
    @GetMapping("/api/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }
}
