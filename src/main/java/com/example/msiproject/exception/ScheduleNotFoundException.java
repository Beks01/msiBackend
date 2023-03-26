package com.example.msiproject.exception;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException(Long id) {
        super("Could not find Schedule with id: " + id);
    }

}
