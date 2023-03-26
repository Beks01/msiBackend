package com.example.msiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.DayOfWeek;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {
    private Long id;
    private DayOfWeek dayOfWeek;
    private Time since;
    private Time until;
}
