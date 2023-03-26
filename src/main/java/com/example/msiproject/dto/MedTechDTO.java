package com.example.msiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedTechDTO {

    private Long id;
    private String name;
    private String medicineCode;
    private String isAbout;

}
