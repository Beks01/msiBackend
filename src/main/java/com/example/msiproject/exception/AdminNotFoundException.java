package com.example.msiproject.exception;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(Long id) {
        super("Could not find Admin with id: " + id);
    }
}
