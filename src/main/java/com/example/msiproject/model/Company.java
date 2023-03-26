package com.example.msiproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isAbout")
    private String isAbout;

    @Column(name = "email")
    private String email;

    //Medicines
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Medicine> medicines;

    //Techs
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<MedTech> medTeches;




}
