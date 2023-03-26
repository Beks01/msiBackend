package com.example.msiproject.service;

import com.example.msiproject.dto.PatientDTO;
import com.example.msiproject.dto.PatientProfileDTO;
import com.example.msiproject.exception.PatientNotFoundException;
import com.example.msiproject.model.Patient;
import com.example.msiproject.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository repository;

    private final ModelMapper mapper;

    public PatientService(PatientRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = repository.findAll();
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOs.add(mapper.map(patient, PatientDTO.class));
        }
        return patientDTOs;
    }

    public Optional<PatientDTO> getPatientById(Long id) {
        Patient patient = repository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        return Optional.of(mapper.map(patient, PatientDTO.class));
    }

    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = mapper.map(patientDTO, Patient.class);
        return repository.save(patient);
    }

    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patientToUpdate = repository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));

        Patient updatePatient = mapper.map(patientDTO, Patient.class);

        updatePatient.setId(patientToUpdate.getId());

        return mapper.map(repository.save(updatePatient), PatientDTO.class);

    }

    // Update only certain columns from the database
    public Patient updatePatientProfile(Long id, PatientProfileDTO patientProfileDTO) {
        Patient patientToUpdate = repository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));

        mapper.map(patientProfileDTO, patientToUpdate);

        return repository.save(patientToUpdate);

    }

    public void deletePatient(Long id) {
        Patient patient = repository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        repository.delete(patient);
    }


}
