package com.example.msiproject.dto;

import com.example.msiproject.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserValidationDTO {
    private String login;
    private String password;
    private Roles role;
}
