package com.example.msiproject.controller;

import com.example.msiproject.dto.PatientDTO;
import com.example.msiproject.dto.PatientProfileDTO;
import com.example.msiproject.model.Patient;
import com.example.msiproject.service.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;


    public PatientController(PatientService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Patients (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllPatients")
    ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(service.getAllPatients());


    }


    @ApiOperation(value = "Get Patient by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/{patient_id}")
    ResponseEntity<PatientDTO> getPatientById(@PathVariable("patient_id") Long id) {
        return ResponseEntity.ok().body(service.getPatientById(id).get());
    }


    @ApiOperation(value = "Create Patient (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createPatient")
    ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok().body(service.createPatient(patientDTO));
    }

    @ApiOperation(value = "Update Patient (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updatePatient/{id}")
    ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok().body(service.updatePatient(id, patientDTO));
    }


    @ApiOperation(value = "Update Patient Profile (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updatePatientProfile/{id}")
    ResponseEntity<Patient> updatePatientProfile(@PathVariable("id") Long id, @RequestBody PatientProfileDTO patientProfileDTO) {
        return ResponseEntity.ok().body(service.updatePatientProfile(id, patientProfileDTO));
    }


    @ApiOperation(value = "Delete Patient (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteDoctor/{id}")
    ResponseEntity<Void> deletePatient(@PathVariable("id") long id) {
        service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
