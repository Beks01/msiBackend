package com.example.msiproject.controller;

import com.example.msiproject.dto.ScheduleDTO;
import com.example.msiproject.model.Schedule;
import com.example.msiproject.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all Schedules (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllSchedules")
    ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
        return ResponseEntity.ok(service.getAllSchedule());
    }


    @ApiOperation(value = "Get Schedule by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/{schedule_id}")
    ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable("schedule_id") Long id) {
        return ResponseEntity.ok().body(service.getScheduleById(id).get());
    }


    @ApiOperation(value = "Create Schedule (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createSchedule")
    ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok().body(service.createSchedule(scheduleDTO));
    }


    @ApiOperation(value = "Update Schedule (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateSchedule/{id}")
    ResponseEntity<ScheduleDTO> updateDoctor(@PathVariable("id") Long id, @RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok().body(service.updateSchedule(id, scheduleDTO));
    }


}
