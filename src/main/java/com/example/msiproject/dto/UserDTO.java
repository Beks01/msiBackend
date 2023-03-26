package com.example.msiproject.dto;

import com.example.msiproject.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private boolean otpUsed;
    private Role role;
    private String phoneNumber;
    private String email;

}
