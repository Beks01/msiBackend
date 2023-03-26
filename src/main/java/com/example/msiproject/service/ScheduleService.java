package com.example.msiproject.service;

import com.example.msiproject.dto.ScheduleDTO;
import com.example.msiproject.exception.DoctorNotFoundException;
import com.example.msiproject.exception.ScheduleNotFoundException;
import com.example.msiproject.model.Schedule;
import com.example.msiproject.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository repository;

    private final ModelMapper mapper;

    public ScheduleService(ScheduleRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ScheduleDTO> getAllSchedule() {
        List<Schedule> schedules = repository.findAll();
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleDTOs.add(mapper.map(schedule, ScheduleDTO.class));
        }
        return scheduleDTOs;
    }

    public Optional<ScheduleDTO> getScheduleById(Long id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        return Optional.of(mapper.map(schedule, ScheduleDTO.class));
    }

    public Schedule createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = mapper.map(scheduleDTO, Schedule.class);
        return repository.save(schedule);
    }

    public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO) {
        Schedule scheduleToUpdate = repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));

        Schedule updateSchedule = mapper.map(scheduleDTO, Schedule.class);

        updateSchedule.setId(scheduleToUpdate.getId());

        return mapper.map(repository.save(updateSchedule), ScheduleDTO.class);

    }

    public void deleteSchedule(Long id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        repository.delete(schedule);
    }


}
