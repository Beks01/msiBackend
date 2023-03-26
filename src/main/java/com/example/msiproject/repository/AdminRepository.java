package com.example.msiproject.repository;

import com.example.msiproject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {

//    @Query("SELECT tbl FROM Admin tbl WHERE tbl.firstName = :firstName")
//    Admin findByName(String firstName);
}
