package com.example.msiproject.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Long id) {
        super("Could not find Company with id: " + id);
    }
}
