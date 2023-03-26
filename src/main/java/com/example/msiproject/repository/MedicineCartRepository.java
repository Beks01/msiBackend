package com.example.msiproject.repository;

import com.example.msiproject.model.MedicineCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineCartRepository extends JpaRepository<MedicineCart, Long> {
}
