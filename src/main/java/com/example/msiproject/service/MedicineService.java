package com.example.msiproject.service;

import com.example.msiproject.dto.MedicineDTO;
import com.example.msiproject.exception.MedicineNotFoundException;
import com.example.msiproject.model.Medicine;
import com.example.msiproject.repository.MedicineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    private final MedicineRepository repository;

    private final ModelMapper mapper;

    public MedicineService(MedicineRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MedicineDTO> getAllMedicine() {
        List<Medicine> medicines = repository.findAll();
        List<MedicineDTO> mediciDTOs = new ArrayList<>();
        for (Medicine medicine : medicines) {
            mediciDTOs.add(mapper.map(medicine, MedicineDTO.class));
        }
        return mediciDTOs;
    }


    public Optional<MedicineDTO> getMedicineById(Long id) {
        Medicine medicine = repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));
        return Optional.of(mapper.map(medicine, MedicineDTO.class));
    }

    public Medicine createMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = mapper.map(medicineDTO, Medicine.class);
        return repository.save(medicine);
    }

    public MedicineDTO updateMedicine(Long id, MedicineDTO medicineDTO) {
        Medicine medicineToUpdate = repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));

        Medicine updateMedicine = mapper.map(medicineDTO, Medicine.class);

        updateMedicine.setId(medicineToUpdate.getId());

        return mapper.map(repository.save(updateMedicine), MedicineDTO.class);

    }

    public void deleteMedicine(Long id) {
        Medicine medicine = repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));
        repository.delete(medicine);
    }


}
