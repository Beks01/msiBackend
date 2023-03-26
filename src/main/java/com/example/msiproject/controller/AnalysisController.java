package com.example.msiproject.controller;

import com.example.msiproject.dto.AnalysisDTO;
import com.example.msiproject.model.Analysis;
import com.example.msiproject.service.AnalysisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalysisController {
    private final AnalysisService service;

    public AnalysisController(AnalysisService service) {
        this.service = service;
    }
    @ApiOperation(value = "Get all Analyses (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllAdmins")
    ResponseEntity<List<AnalysisDTO>> getAllAnalyses() {
        return ResponseEntity.ok(service.getAllAnalyses());
    }

    @ApiOperation(value = "Get Analyses by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAnalysisById/{analysis_id}")
    ResponseEntity<AnalysisDTO> getAnalysisById(@PathVariable("analysis_id") Long id) {
        return ResponseEntity.ok().body(service.getAnalysisById(id).get());
    }


    @ApiOperation(value = "Create Analyses (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createAnalyses")
    ResponseEntity<Analysis> createAnalyses(@RequestBody AnalysisDTO analysisDTO) {
        return ResponseEntity.ok().body(service.createAnalysis(analysisDTO));
    }

    @ApiOperation(value = "Update Analyses (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateAnalyses/{id}")
    ResponseEntity<AnalysisDTO> updateAnalyses(@PathVariable("id") Long id, @RequestBody AnalysisDTO analysisDTO) {
        return ResponseEntity.ok().body(service.updateAnalysis(id, analysisDTO));
    }

    @ApiOperation(value = "Delete Analyses (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteAdmin/{id}")
    ResponseEntity<Void> deleteAnalyses(@PathVariable("id") long id) {
        service.deleteAnalysis(id);
        return ResponseEntity.noContent().build();
    }




}
