package com.example.msiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedSrvDTO {
    private Long id;
    private Date since;
    private Date until;
    private String about;

}
