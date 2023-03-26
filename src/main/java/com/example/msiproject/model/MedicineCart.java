package com.example.msiproject.model;


import com.example.msiproject.model.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "medicineCarts")
public class MedicineCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "bloodPressure")
    private String bloodPressure;

    //analyses
    @OneToMany(mappedBy = "medicineCart", cascade = CascadeType.ALL)
    private List<Analysis> analyses;

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "sex")
    @Enumerated
    private Sex sex;

    //appointments
    @OneToMany(mappedBy = "medicineCart", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "insurance")
    private String insurance;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    //medServices
    @OneToMany(mappedBy = "medicineCart", cascade = CascadeType.ALL)
    private List<MedService> medServices;

}
