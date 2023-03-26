package com.example.msiproject.service;

import com.example.msiproject.dto.CompanyDTO;
import com.example.msiproject.exception.CompanyNotFoundException;
import com.example.msiproject.model.Company;
import com.example.msiproject.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    private final ModelMapper mapper;

    public CompanyService(CompanyRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CompanyDTO> getAllCompany() {
        List<Company> companies = repository.findAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        for (Company company : companies) {
            companyDTOs.add(mapper.map(company, CompanyDTO.class));
        }
        return companyDTOs;
    }

    public Optional<CompanyDTO> getCompanyById(Long id) {
        Company company = repository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        return Optional.of(mapper.map(company, CompanyDTO.class));
    }

    public Company createCompany(CompanyDTO companyDTO) {
        Company company = mapper.map(companyDTO, Company.class);
        return repository.save(company);
    }

    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        Company companyToUpdate = repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));

        Company updateCompany = mapper.map(companyDTO, Company.class);

        updateCompany.setId(companyToUpdate.getId());

        return mapper.map(repository.save(updateCompany), CompanyDTO.class);

    }

    public void deleteCompany(Long id) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
        repository.delete(company);
    }


}
