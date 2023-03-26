package com.example.msiproject.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(Long id) {
        super("Could not find Doctor with id: " + id);
    }
}
