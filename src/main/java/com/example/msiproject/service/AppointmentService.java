package com.example.msiproject.service;

import com.example.msiproject.dto.AppointmentDTO;
import com.example.msiproject.exception.AppointmentNotFoundException;
import com.example.msiproject.model.Appointment;
import com.example.msiproject.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    private final ModelMapper mapper;


    public AppointmentService(AppointmentRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = repository.findAll();
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(mapper.map(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }

    public Optional<AppointmentDTO> getAppointmentById(Long id) {
        Appointment appointment = repository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
        return Optional.of(mapper.map(appointment, AppointmentDTO.class));
    }

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.map(appointmentDTO, Appointment.class);
        return repository.save(appointment);
    }

    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointmentToUpdate = repository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));

        Appointment updateAppointment = mapper.map(appointmentDTO, Appointment.class);

        updateAppointment.setId(appointmentToUpdate.getId());

        return mapper.map(repository.save(updateAppointment), AppointmentDTO.class);
    }

    public void deleteAppointment(Long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));
        repository.delete(appointment);
    }

}
