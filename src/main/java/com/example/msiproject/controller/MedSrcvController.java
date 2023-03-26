package com.example.msiproject.controller;

import com.example.msiproject.dto.MedSrvDTO;
import com.example.msiproject.model.MedService;
import com.example.msiproject.service.MedSrcvService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medsrvcs")
public class MedSrcvController {

    private final MedSrcvService service;

    public MedSrcvController(MedSrcvService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Med Services (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllMedServices")
    ResponseEntity<List<MedSrvDTO>> getAllMedServices() {
        return ResponseEntity.ok(service.getAllMedSrvces());
    }


    @ApiOperation(value = "Get Med Service by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getMedSrvcById/{medsrv_id}")
    ResponseEntity<MedSrvDTO> getMedSrvcById(@PathVariable("medsrv_id") Long id) {
        return ResponseEntity.ok().body(service.getMedSrvcById(id).get());
    }


    @ApiOperation(value = "Create Med Service (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createMedSrvc")
    ResponseEntity<MedService> createMedSrvc(@RequestBody MedSrvDTO medSrvDTO) {
        return ResponseEntity.ok().body(service.createMedSrvc(medSrvDTO));
    }


    @ApiOperation(value = "Update Med Service (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateMedSrvc/{id}")
    ResponseEntity<MedSrvDTO> updateMedSrvc(@PathVariable("id") Long id, @RequestBody MedSrvDTO medSrvDTO) {
        return ResponseEntity.ok().body(service.updateMedSrvc(id, medSrvDTO));
    }


    @ApiOperation(value = "Delete Med Service (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteMedSrvc/{id}")
    ResponseEntity<Void> deleteMedSrvc(@PathVariable("id") long id) {
        service.deleteMedSrvc(id);
        return ResponseEntity.noContent().build();
    }


}
