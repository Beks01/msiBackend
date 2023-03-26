package com.example.msiproject.exception;

public class HospitalNotFoundException extends RuntimeException {

    public HospitalNotFoundException(Long id) {
        super("Could not find Hospital with id: " + id);
    }
}
