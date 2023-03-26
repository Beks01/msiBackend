package com.example.msiproject.service;

import com.example.msiproject.dto.AdminDTO;
import com.example.msiproject.exception.AdminNotFoundException;
import com.example.msiproject.model.Admin;
import com.example.msiproject.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    private final AdminRepository repository;
    private final ModelMapper mapper;

    public AdminService(AdminRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AdminDTO> getAllAdmin() {
        List<Admin> admins = repository.findAll();
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin admin : admins) {
            adminDTOS.add(mapper.map(admin, AdminDTO.class));
        }
        return adminDTOS;
    }

    public Optional<AdminDTO> getAdminById(Long id) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id));
        return Optional.of(mapper.map(admin, AdminDTO.class));
    }

    public Admin createAdmin(AdminDTO adminDTO) {
        Admin admin = mapper.map(adminDTO, Admin.class);
        return repository.save(admin);
    }

    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin adminToUpdate = repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id));

        Admin updateAdmin = mapper.map(adminDTO, Admin.class);

        updateAdmin.setId(adminToUpdate.getId());

        return mapper.map(repository.save(updateAdmin), AdminDTO.class);

    }


    public void deleteAdmin(Long id) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id));
        repository.delete(admin);
    }

}