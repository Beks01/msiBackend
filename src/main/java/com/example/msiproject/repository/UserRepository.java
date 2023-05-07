package com.example.msiproject.repository;

import com.example.msiproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT tbl FROM User tbl WHERE tbl.firstName = ?1")
    Optional<User> findByUsername(String username);


    @Query("SELECT tbl FROM User tbl WHERE tbl.email = ?1")
    Optional<User> findByEmail(String email);
}
