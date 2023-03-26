package com.example.msiproject.controller;

import com.example.msiproject.dto.AppointmentDTO;
import com.example.msiproject.model.Appointment;
import com.example.msiproject.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Appointments (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllAppointments")
    ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(service.getAllAppointments());
    }


    @ApiOperation(value = "Get Appointment by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAppointmentById/{appointment_id}")
    ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("appointment_id") Long id) {
        return ResponseEntity.ok().body(service.getAppointmentById(id).get());
    }

    @ApiOperation(value = "Create Appointment (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createAppointment")
    ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok().body(service.createAppointment(appointmentDTO));
    }

    @ApiOperation(value = "Update Appointment (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateAppointment/{id}")
    ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("id") Long id, @RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok().body(service.updateAppointment(id, appointmentDTO));
    }

    @ApiOperation(value = "Delete Appointment (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteAppointment/{id}")
    ResponseEntity<Void> deleteAppointment(@PathVariable("id") long id) {
        service.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

}
