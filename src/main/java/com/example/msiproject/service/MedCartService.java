package com.example.msiproject.service;

import com.example.msiproject.dto.MedicineCartDTO;
import com.example.msiproject.exception.MedCartNotFoundException;
import com.example.msiproject.model.MedicineCart;
import com.example.msiproject.repository.MedicineCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedCartService {

    private final MedicineCartRepository repository;

    private final ModelMapper mapper;

    public MedCartService(MedicineCartRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MedicineCartDTO> getAllMedicineCart() {
        List<MedicineCart> medicineCarts = repository.findAll();
        List<MedicineCartDTO> medicineCartDTOS = new ArrayList<>();
        for (MedicineCart medicineCart : medicineCarts) {
            medicineCartDTOS.add(mapper.map(medicineCart, MedicineCartDTO.class));
        }
        return medicineCartDTOS;
    }

    public Optional<MedicineCartDTO> getMedicineCartById(Long id) {
        MedicineCart medicineCart = repository.findById(id)
                .orElseThrow(() -> new MedCartNotFoundException(id));
        return Optional.of(mapper.map(medicineCart, MedicineCartDTO.class));
    }

    public MedicineCart createMedicineCart(MedicineCartDTO medicineDTO) {
        MedicineCart medicineCart = mapper.map(medicineDTO, MedicineCart.class);
        return repository.save(medicineCart);
    }

    public MedicineCartDTO updateMedicineCart(Long id, MedicineCartDTO medicineCartDTO) {
        MedicineCart medicineCartToUpdate = repository.findById(id)
                .orElseThrow(() -> new MedCartNotFoundException(id));

        MedicineCart updateMedicineCart = mapper.map(medicineCartDTO, MedicineCart.class);

        updateMedicineCart.setId(medicineCartToUpdate.getId());

        return mapper.map(repository.save(updateMedicineCart), MedicineCartDTO.class);

    }

    public void deleteMedicineCart(Long id) {
        MedicineCart medicineCart = repository.findById(id)
                .orElseThrow(() -> new MedCartNotFoundException(id));
        repository.delete(medicineCart);
    }


}
