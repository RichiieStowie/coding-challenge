package com.example.codingchallenge.controller;

import com.example.codingchallenge.dto.LoginDto;
import com.example.codingchallenge.dto.RegistrationDto;
import com.example.codingchallenge.models.UserModel;
import com.example.codingchallenge.services.UserModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class UserModelController {
    private UserModelService userModelService;
     @Autowired
    public UserModelController(UserModelService userModelService) {
        this.userModelService = userModelService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody RegistrationDto registrationDto){
         UserModel user = userModelService.createANewUser(registrationDto);
         if(user!=null){
             return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
         }
         else{
             return new ResponseEntity<>("User already exists",HttpStatus.BAD_REQUEST);
         }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
         UserModel user = userModelService.loginUser(loginDto);
         if(user!=null){
             return new ResponseEntity<>(user,HttpStatus.OK);
         }else{
             return new ResponseEntity<>("Invalid credentials",HttpStatus.BAD_REQUEST);
         }
    }

    @GetMapping("/Users")
    public ResponseEntity<?> getAllUsers(){
         List<UserModel> userModelList= userModelService.getAllUsers();

         return new ResponseEntity<>(userModelList,HttpStatus.ACCEPTED);
    }

}
