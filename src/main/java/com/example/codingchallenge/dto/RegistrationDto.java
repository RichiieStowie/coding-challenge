package com.example.codingchallenge.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
