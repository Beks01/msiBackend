package com.example.msiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "day")
    private DayOfWeek dayOfWeek;

    @Column(name = "since")
    private Time since;

    @Column(name = "until")
    private Time until;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
