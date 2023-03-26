package com.example.msiproject.controller;

import com.example.msiproject.dto.MedicineDTO;
import com.example.msiproject.model.Medicine;
import com.example.msiproject.service.MedicineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Medicines (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllMedicines")
    ResponseEntity<List<MedicineDTO>> getAllMedicines() {
        return ResponseEntity.ok(service.getAllMedicine());
    }

    @ApiOperation(value = "Get Medicine by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getMedicineById/{medicine_id}")
    ResponseEntity<MedicineDTO> getMedicineById(@PathVariable("medicine_id") Long id) {
        return ResponseEntity.ok().body(service.getMedicineById(id).get());
    }

    @ApiOperation(value = "Create Medicine (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createMedicine")
    ResponseEntity<Medicine> createMedicine(@RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok().body(service.createMedicine(medicineDTO));
    }

    @ApiOperation(value = "Update Medicine (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateMedicine/{id}")
    ResponseEntity<MedicineDTO> updateMedicine(@PathVariable("id") Long id, @RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok().body(service.updateMedicine(id, medicineDTO));
    }

    @ApiOperation(value = "Delete Medicine (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteMedicine/{id}")
    ResponseEntity<Void> deleteMedicine(@PathVariable("id") long id) {
        service.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }


}
