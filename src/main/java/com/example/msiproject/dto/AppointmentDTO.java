package com.example.msiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentDTO {
    private Long id;
    private String name;
    private Date date;
    private Time time;
    private String result;

}
