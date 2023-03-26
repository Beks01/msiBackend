package com.example.msiproject.dto;

import com.example.msiproject.model.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicineCartDTO {
    private Long id;
    private Date birthDate;
    private String bloodPressure;
    private String bloodType;
    private Sex sex;
    private String occupation;
    private String insurance;

}
