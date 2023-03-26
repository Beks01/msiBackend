package com.example.msiproject.controller;

import com.example.msiproject.dto.DoctorDTO;
import com.example.msiproject.model.Doctor;
import com.example.msiproject.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Doctors (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllDoctors")
    ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(service.getAllDoctor());
    }

    @ApiOperation(value = "Get Doctor by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/{doctor_id}")
    ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("doctor_id") Long id) {
        return ResponseEntity.ok().body(service.getDoctorById(id).get());
    }

    @ApiOperation(value = "Create Doctor (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createDoctor")
    ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok().body(service.createDoctor(doctorDTO));
    }

    @ApiOperation(value = "Update Doctor (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateDoctor/{id}")
    ResponseEntity<DoctorDTO> updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok().body(service.updateDoctor(id, doctorDTO));
    }

    @ApiOperation(value = "Delete Doctor (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteDoctor/{id}")
    ResponseEntity<Void> deleteDoctor(@PathVariable("id") long id) {
        service.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
