package com.example.msiproject.controller;

import com.example.msiproject.dto.CompanyDTO;
import com.example.msiproject.model.Company;
import com.example.msiproject.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Companies (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllCompanies")
    ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompany());
    }


    @ApiOperation(value = "Get Company by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/{company_id}")
    ResponseEntity<CompanyDTO> getCompanyById(@PathVariable("company_id") Long id) {
        return ResponseEntity.ok().body(service.getCompanyById(id).get());
    }


    @ApiOperation(value = "Create Company (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createCompany")
    ResponseEntity<Company> createCompany(@RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok().body(service.createCompany(companyDTO));
    }


    @ApiOperation(value = "Update Company (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateDoctor/{id}")
    ResponseEntity<CompanyDTO> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok().body(service.updateCompany(id, companyDTO));
    }

    @ApiOperation(value = "Delete Company (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteCompany/{id}")
    ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }





















}
