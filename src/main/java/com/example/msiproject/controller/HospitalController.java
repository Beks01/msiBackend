package com.example.msiproject.controller;

import com.example.msiproject.dto.HospitalDTO;
import com.example.msiproject.model.Hospital;
import com.example.msiproject.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Hospitals (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllHospitals")
    ResponseEntity<List<HospitalDTO>> getAllHospitals() {
        return ResponseEntity.ok(service.getAllHospital());
    }

    @ApiOperation(value = "Get Hospital by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAdminById/{hospital_id}")
    ResponseEntity<HospitalDTO> getHospitalById(@PathVariable("hospital_id") Long id) {
        return ResponseEntity.ok().body(service.getHospitalById(id).get());
    }

    @ApiOperation(value = "Create Hospital (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createHospital")
    ResponseEntity<Hospital> createHospital(@RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok().body(service.createHospital(hospitalDTO));
    }

    @ApiOperation(value = "Update Hospital (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateHospital/{id}")
    ResponseEntity<HospitalDTO> updateHospital(@PathVariable("id") Long id, @RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok().body(service.updateHospital(id, hospitalDTO));
    }

    @ApiOperation(value = "Delete Hospital (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteHospital/{id}")
    ResponseEntity<Void> deleteHospital(@PathVariable("id") long id) {
        service.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }


}
