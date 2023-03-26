package com.example.msiproject.exception;

public class MedTechNotFoundException extends RuntimeException {
    public MedTechNotFoundException(Long id) {
        super("Could not find Medicine Tech with id: " + id);
    }
}
