package com.example.msiproject.service;

import com.example.msiproject.dto.AnalysisDTO;
import com.example.msiproject.exception.AnalysisNotFoundException;
import com.example.msiproject.model.Analysis;
import com.example.msiproject.repository.AnalysisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnalysisService {

    private final AnalysisRepository repository;
    private final ModelMapper mapper;

    public AnalysisService(AnalysisRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<AnalysisDTO> getAllAnalyses() {
        List<Analysis> analyses = repository.findAll();
        List<AnalysisDTO> analysisDTOs = new ArrayList<>();
        for (Analysis analysis : analyses) {
            analysisDTOs.add(mapper.map(analysis, AnalysisDTO.class));
        }
        return analysisDTOs;
    }

    public Optional<AnalysisDTO> getAnalysisById(Long id) {
        Analysis analysis = repository.findById(id)
                .orElseThrow(() -> new AnalysisNotFoundException(id));
        return Optional.of(mapper.map(analysis, AnalysisDTO.class));
    }

    public Analysis createAnalysis(AnalysisDTO analysisDTO) {
        Analysis analysis = mapper.map(analysisDTO, Analysis.class);
        return repository.save(analysis);
    }

    public AnalysisDTO updateAnalysis(Long id, AnalysisDTO adminDTO) {
        Analysis analysisToUpdate = repository.findById(id)
                .orElseThrow(() -> new AnalysisNotFoundException(id));

        Analysis updateAnalysis = mapper.map(adminDTO, Analysis.class);

        updateAnalysis.setId(analysisToUpdate.getId());

        return mapper.map(repository.save(updateAnalysis), AnalysisDTO.class);

    }

    public void deleteAnalysis(Long id) {
        Analysis analysis = repository.findById(id)
                .orElseThrow(() -> new AnalysisNotFoundException(id));
        repository.delete(analysis);
    }


}
