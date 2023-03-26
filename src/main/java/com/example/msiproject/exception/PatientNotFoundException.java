package com.example.msiproject.exception;

public class PatientNotFoundException extends RuntimeException {


    public PatientNotFoundException(Long id) {
        super("Could not find Patient with id: " + id);
    }


}
