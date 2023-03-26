package com.example.msiproject.service;

import com.example.msiproject.dto.MedTechDTO;
import com.example.msiproject.exception.MedTechNotFoundException;
import com.example.msiproject.exception.MedicineNotFoundException;
import com.example.msiproject.model.MedTech;
import com.example.msiproject.repository.MedTechRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedTechService {

    private final MedTechRepository repository;

    private final ModelMapper mapper;

    public MedTechService(MedTechRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MedTechDTO> getAllMedTech() {
        List<MedTech> teches = repository.findAll();
        List<MedTechDTO> techDTOS = new ArrayList<>();
        for (MedTech tech : teches) {
            techDTOS.add(mapper.map(tech, MedTechDTO.class));
        }
        return techDTOS;
    }


    public Optional<MedTechDTO> getMedTechById(Long id) {
        MedTech tech = repository.findById(id)
                .orElseThrow(() -> new MedTechNotFoundException(id));
        return Optional.of(mapper.map(tech, MedTechDTO.class));
    }


    public MedTech createMedTech(MedTechDTO medTechDTO) {
        MedTech medTech = mapper.map(medTechDTO, MedTech.class);
        return repository.save(medTech);
    }

    public MedTechDTO updateMedTech(Long id, MedTechDTO medTechDTO) {
        MedTech medTechToUpdate = repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));

        MedTech updateMedTech = mapper.map(medTechDTO, MedTech.class);

        updateMedTech.setId(medTechToUpdate.getId());

        return mapper.map(repository.save(updateMedTech), MedTechDTO.class);

    }

    public void deleteMedTech(Long id) {
        MedTech medTech = repository.findById(id)
                .orElseThrow(() -> new MedTechNotFoundException(id));
        repository.delete(medTech);
    }


}
