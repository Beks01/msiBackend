package com.example.msiproject.repository;

import com.example.msiproject.model.MedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineServiceRepository extends JpaRepository<MedService, Long> {
}
