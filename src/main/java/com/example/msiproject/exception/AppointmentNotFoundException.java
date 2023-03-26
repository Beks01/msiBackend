package com.example.msiproject.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(Long id) {
        super("Could not find Appointment with id: " + id);
    }
}
