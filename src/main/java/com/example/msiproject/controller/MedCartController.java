package com.example.msiproject.controller;

import com.example.msiproject.dto.MedicineCartDTO;
import com.example.msiproject.model.MedicineCart;
import com.example.msiproject.service.MedCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medcarts")
public class MedCartController {

    private final MedCartService service;

    public MedCartController(MedCartService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all MedCart (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllAdmins")
    ResponseEntity<List<MedicineCartDTO>> getAllMedCarts() {
        return ResponseEntity.ok(service.getAllMedicineCart());
    }

    @ApiOperation(value = "Get MedCart by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAdminById/{admin_id}")
    ResponseEntity<MedicineCartDTO> getMedCartById(@PathVariable("admin_id") Long id) {
        return ResponseEntity.ok().body(service.getMedicineCartById(id).get());
    }

    @ApiOperation(value = "Create MedCart (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createMedCart")
    ResponseEntity<MedicineCart> createMedCart(@RequestBody MedicineCartDTO medicineCartDTO) {
        return ResponseEntity.ok().body(service.createMedicineCart(medicineCartDTO));
    }

    @ApiOperation(value = "Update MedCart (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateAdmin/{id}")
    ResponseEntity<MedicineCartDTO> updateMedCart(@PathVariable("id") Long id, @RequestBody MedicineCartDTO medicineCartDTO) {
        return ResponseEntity.ok().body(service.updateMedicineCart(id, medicineCartDTO));
    }

    @ApiOperation(value = "Delete MedCart (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteMedCart/{id}")
    ResponseEntity<Void> deleteMedCart(@PathVariable("id") long id) {
        service.deleteMedicineCart(id);
        return ResponseEntity.noContent().build();
    }
}
