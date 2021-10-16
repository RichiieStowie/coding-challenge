package com.example.codingchallenge.services;


import com.example.codingchallenge.dto.LoginDto;
import com.example.codingchallenge.dto.RegistrationDto;
import com.example.codingchallenge.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModelService {
    UserModel createANewUser(RegistrationDto user);
    UserModel loginUser(LoginDto loginDto);
    List<UserModel> getAllUsers();
}
