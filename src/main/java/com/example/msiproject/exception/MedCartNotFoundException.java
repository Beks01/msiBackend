package com.example.msiproject.exception;

public class MedCartNotFoundException extends RuntimeException {
    public MedCartNotFoundException(Long id) {
        super("Could not find MedCart with id: " + id);
    }
}
