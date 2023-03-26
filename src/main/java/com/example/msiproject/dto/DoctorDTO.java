package com.example.msiproject.dto;

import com.example.msiproject.model.Hospital;
import com.example.msiproject.model.Schedule;
import com.example.msiproject.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDTO {


    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String phoneNumber;
    private Role role;
    private boolean otpUsed;



}
