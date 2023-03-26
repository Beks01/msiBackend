package com.example.msiproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "medServices")
public class MedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "since")
    private Date since;

    @Column(name = "until")
    private Date until;

    @Column(name = "about")
    private String about;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicineCart_id")
    private MedicineCart medicineCart;
}
