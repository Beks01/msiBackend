package com.example.msiproject.exception;

public class MedSrvcNotFoundException extends RuntimeException {
    public MedSrvcNotFoundException(Long id) {
        super("Could not find MedService with id: " + id);
    }
}
