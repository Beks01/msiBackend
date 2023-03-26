package com.example.msiproject.repository;

import com.example.msiproject.model.MedTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedTechRepository extends JpaRepository<MedTech, Long> {
}
