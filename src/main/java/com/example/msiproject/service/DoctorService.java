package com.example.msiproject.service;

import com.example.msiproject.dto.DoctorDTO;
import com.example.msiproject.exception.DoctorNotFoundException;
import com.example.msiproject.model.Doctor;
import com.example.msiproject.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository repository;

    private final ModelMapper mapper;

    public DoctorService(DoctorRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DoctorDTO> getAllDoctor() {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOs.add(mapper.map(doctor, DoctorDTO.class));
        }
        return doctorDTOs;
    }

    public Optional<DoctorDTO> getDoctorById(Long id) {
        Doctor doctor = repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        return Optional.of(mapper.map(doctor, DoctorDTO.class));
    }

    public Doctor createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapper.map(doctorDTO, Doctor.class);
        return repository.save(doctor);
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO adminDTO) {
        Doctor doctorToUpdate = repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));

        Doctor updateDoctor = mapper.map(adminDTO, Doctor.class);

        updateDoctor.setId(doctorToUpdate.getId());

        return mapper.map(repository.save(updateDoctor), DoctorDTO.class);

    }

    public void deleteDoctor(Long id) {
        Doctor doctor = repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        repository.delete(doctor);
    }


}
