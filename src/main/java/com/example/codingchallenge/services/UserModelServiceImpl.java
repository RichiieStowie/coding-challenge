package com.example.codingchallenge.services;

import com.example.codingchallenge.dto.RegistrationDto;
import com.example.codingchallenge.dto.LoginDto;
import com.example.codingchallenge.models.UserModel;
import com.example.codingchallenge.repository.UserModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class UserModelServiceImpl implements UserModelService{
    private UserModelRepository userModelRepository;

    @Autowired
    public UserModelServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserModel createANewUser(RegistrationDto registrationDto) {
        Optional<UserModel> user1= userModelRepository.findByEmail(registrationDto.getEmail());
        if(user1.isEmpty()){
       UserModel user= UserModel.builder()
               .email(registrationDto.getEmail())
                .password(registrationDto.getPassword())
                .lastname(registrationDto.getLastname())
                .firstname(registrationDto.getFirstname())
                .build();
        log.info("User created with email: " +user.getEmail());
        return userModelRepository.save(user);
        }else{
            throw new IllegalArgumentException("This User already exists");
        }


    }

    @Override
    @Cacheable(value="userModel")
    public UserModel loginUser(LoginDto user1) {
        Optional<UserModel> user= userModelRepository.findByEmailAndPassword(user1.getEmail(), user1.getPassword());
        Boolean status;

        if(user.isPresent()){
            status=true;
        }else{
            status=false;
        }
        return user.get();
    }

    @Override
    @Cacheable(value = "userModel")
    public List<UserModel> getAllUsers() {
        List<UserModel> userModelList= userModelRepository.findAll();
        return userModelList;
    }
}
