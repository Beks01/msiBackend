package com.example.msiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicineDTO {
    private Long id;
    private String name;
    private String medicineCode;
    private String isAbout;

}
