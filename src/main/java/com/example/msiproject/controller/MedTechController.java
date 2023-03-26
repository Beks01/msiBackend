package com.example.msiproject.controller;

import com.example.msiproject.dto.MedTechDTO;
import com.example.msiproject.model.MedTech;
import com.example.msiproject.service.MedTechService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medteches")
public class MedTechController {
    private final MedTechService service;

    public MedTechController(MedTechService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all MedTeches (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllMedTeches")
    ResponseEntity<List<MedTechDTO>> getAllTeches() {
        return ResponseEntity.ok(service.getAllMedTech());
    }

    @ApiOperation(value = "Get MedTeches by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getMedicineById/{medteches_id}")
    ResponseEntity<MedTechDTO> getMedTechById(@PathVariable("medteches_id") Long id) {
        return ResponseEntity.ok().body(service.getMedTechById(id).get());
    }

    @ApiOperation(value = "Create MedTech (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createMedTech")
    ResponseEntity<MedTech> createMedTech(@RequestBody MedTechDTO medTechDTO) {
        return ResponseEntity.ok().body(service.createMedTech(medTechDTO));
    }

    @ApiOperation(value = "Update MedTech (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateMedTech/{id}")
    ResponseEntity<MedTechDTO> updateMedTech(@PathVariable("id") Long id, @RequestBody MedTechDTO medTechDTO) {
        return ResponseEntity.ok().body(service.updateMedTech(id, medTechDTO));
    }

    @ApiOperation(value = "Delete MedTech (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteMedTech/{id}")
    ResponseEntity<Void> deleteMedTech(@PathVariable("id") long id) {
        service.deleteMedTech(id);
        return ResponseEntity.noContent().build();
    }


}
