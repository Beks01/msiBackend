package com.example.msiproject.dto;

import com.example.msiproject.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {
    /*  This is Registration DTO */

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String phoneNumber;
    private Roles role;
    private boolean otpUsed;

}
