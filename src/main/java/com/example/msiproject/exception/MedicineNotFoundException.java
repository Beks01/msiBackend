package com.example.msiproject.exception;

public class MedicineNotFoundException extends RuntimeException {
    public MedicineNotFoundException(Long id) {
        super("Could not find Medicine with id: " + id);
    }
}
