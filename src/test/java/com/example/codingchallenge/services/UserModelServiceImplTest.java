package com.example.codingchallenge.services;

import com.example.codingchallenge.dto.LoginDto;
import com.example.codingchallenge.dto.RegistrationDto;
import com.example.codingchallenge.models.UserModel;
import com.example.codingchallenge.repository.UserModelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserModelServiceImplTest {
    @Mock
    private UserModelRepository userModelRepository;
    @InjectMocks
    private UserModelServiceImpl userModelService;

    @Test
    void createANewUser() {
        RegistrationDto registrationDto= new RegistrationDto();
        registrationDto.setEmail("tom@example.com");
        registrationDto.setFirstname("tom");
        registrationDto.setLastname("ben");
        registrationDto.setPassword("1234");
        UserModel user= UserModel.builder()
                .email(registrationDto.getEmail())
                .password(registrationDto.getPassword())
                .lastname(registrationDto.getLastname())
                .firstname(registrationDto.getFirstname())
                .build();
        System.out.println(user.getEmail());
        BDDMockito.given(userModelRepository.findByEmail(registrationDto.getEmail())).willReturn(Optional.of(user));
        assertThrows(IllegalArgumentException.class,()->{userModelService.createANewUser(registrationDto);});

    }

    @Test
    void loginUser() {
        UserModel user1= UserModel.builder()
                .email("tom@example.com")
                .password("1234")
                .build();
        LoginDto loginDto= new LoginDto();
        loginDto.setEmail("tom@example.com");
        loginDto.setPassword("1234");
        BDDMockito.given(userModelRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword())).willReturn(Optional.of(user1));
        UserModel user2= userModelService.loginUser(loginDto);
        Assertions.assertThat(user2).isNotNull();
    }

    @Test
    void getAllUsers() {
        UserModel user1 = UserModel.builder().email("tom@example.com").build();
        UserModel user2 = UserModel.builder().email("ben@example.com").build();
        List<UserModel> userModelList= new ArrayList<>();
        userModelList.add(user1);
        userModelList.add(user2);
        BDDMockito.given(userModelRepository.findAll()).willReturn(userModelList);
        List<UserModel>userModels= userModelService.getAllUsers();
        Assertions.assertThat(userModels.size()).isEqualTo(2);



    }
}