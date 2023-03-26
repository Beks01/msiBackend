package com.example.msiproject.service;

import com.example.msiproject.dto.MedSrvDTO;
import com.example.msiproject.dto.MedicineDTO;
import com.example.msiproject.exception.MedSrvcNotFoundException;
import com.example.msiproject.model.MedService;
import com.example.msiproject.repository.MedicineServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedSrcvService {

    private final MedicineServiceRepository repository;

    private final ModelMapper mapper;

    public MedSrcvService(MedicineServiceRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MedSrvDTO> getAllMedSrvces() {
        List<MedService> medServices = repository.findAll();
        List<MedSrvDTO> medSrvDTOS = new ArrayList<>();
        for (MedService medicineService : medServices) {
            medSrvDTOS.add(mapper.map(medicineService, MedSrvDTO.class));
        }
        return medSrvDTOS;
    }

    public Optional<MedSrvDTO> getMedSrvcById(Long id) {
        MedService medService = repository.findById(id)
                .orElseThrow(() -> new MedSrvcNotFoundException(id));
        return Optional.of(mapper.map(medService, MedSrvDTO.class));
    }

    public MedService createMedSrvc(MedSrvDTO medSrvDTO) {
        MedService medService = mapper.map(medSrvDTO, MedService.class);
        return repository.save(medService);
    }

    public MedSrvDTO updateMedSrvc(Long id, MedSrvDTO medSrvDTO) {
        MedService medSrvcToUpdate = repository.findById(id)
                .orElseThrow(() -> new MedSrvcNotFoundException(id));

        MedService updateMedSrvc = mapper.map(medSrvDTO, MedService.class);

        updateMedSrvc.setId(medSrvcToUpdate.getId());

        return mapper.map(repository.save(updateMedSrvc), MedSrvDTO.class);

    }

    public void deleteMedSrvc(Long id) {
        MedService medService = repository.findById(id)
                .orElseThrow(() -> new MedSrvcNotFoundException(id));
        repository.delete(medService);
    }


}
