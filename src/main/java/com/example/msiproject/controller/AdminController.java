package com.example.msiproject.controller;

import com.example.msiproject.dto.AdminDTO;
import com.example.msiproject.model.Admin;
import com.example.msiproject.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Admins (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllAdmins")
    ResponseEntity<List<AdminDTO>> getAllAdmin() {
        return ResponseEntity.ok(service.getAllAdmin());
    }

    @ApiOperation(value = "Get Admin by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAdminById/{admin_id}")
    ResponseEntity<AdminDTO> getById(@PathVariable("admin_id") Long id) {
        return ResponseEntity.ok().body(service.getAdminById(id).get());
    }

    @ApiOperation(value = "Create Admin (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createAdmin")
    ResponseEntity<Admin> createAdmin(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok().body(service.createAdmin(adminDTO));
    }

    @ApiOperation(value = "Update Admin (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateAdmin/{id}")
    ResponseEntity<AdminDTO> updateAdmin(@PathVariable("id") Long id, @RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok().body(service.updateAdmin(id, adminDTO));
    }

    @ApiOperation(value = "Delete Admin (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteAdmin/{id}")
    ResponseEntity<Void> deleteAdmin(@PathVariable("id") long id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
