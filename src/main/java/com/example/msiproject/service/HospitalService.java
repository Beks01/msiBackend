package com.example.msiproject.service;

import com.example.msiproject.dto.HospitalDTO;
import com.example.msiproject.exception.HospitalNotFoundException;
import com.example.msiproject.model.Hospital;
import com.example.msiproject.repository.HospitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository repository;
    private final ModelMapper mapper;


    public HospitalService(HospitalRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HospitalDTO> getAllHospital() {
        List<Hospital> hospitals = repository.findAll();
        List<HospitalDTO> hospitalDTOs = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            hospitalDTOs.add(mapper.map(hospital, HospitalDTO.class));
        }
        return hospitalDTOs;
    }


    public Optional<HospitalDTO> getHospitalById(Long id) {
        Hospital hospital = repository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));
        return Optional.of(mapper.map(hospital, HospitalDTO.class));
    }

    public Hospital createHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = mapper.map(hospitalDTO, Hospital.class);
        return repository.save(hospital);
    }

    public HospitalDTO updateHospital(Long id, HospitalDTO hospitalDTO) {
        Hospital hospitalToUpdate = repository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));

        Hospital updateHospital = mapper.map(hospitalDTO, Hospital.class);

        updateHospital.setId(hospitalToUpdate.getId());

        return mapper.map(repository.save(updateHospital), HospitalDTO.class);
    }

    public void deleteHospital(Long id) {
        Hospital hospital = repository.findById(id)
                .orElseThrow(() -> new HospitalNotFoundException(id));
        repository.delete(hospital);
    }

}
