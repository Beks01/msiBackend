package com.example.msiproject.exception;

public class AnalysisNotFoundException extends RuntimeException {
    public AnalysisNotFoundException(Long id) {
        super("Could not find Analysis with id: " + id);
    }
}
