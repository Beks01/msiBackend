package com.example.msiproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    // getters and setters

}
