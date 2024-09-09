package com.maiia.pro.controller;

import com.maiia.pro.controller.dto.AppointmentDto;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.mappers.AppointmentMapper;
import com.maiia.pro.model.AppointmentModel;
import com.maiia.pro.service.ProAppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProAppointmentController {
    @Autowired
    private ProAppointmentService proAppointmentService;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @ApiOperation(value = "Get appointments by practitionerId")
    @GetMapping("/{practitionerId}")
    public List<Appointment> getAppointmentsByPractitioner(@PathVariable final Integer practitionerId) {
        return proAppointmentService.findByPractitionerId(practitionerId);
    }

    @ApiOperation(value = "Get all appointments")
    @GetMapping
    public List<Appointment> getAppointments() {
        return proAppointmentService.findAll();
    }

    @ApiOperation(value = "Create a new appointment")
    @PostMapping
    public AppointmentDto createAppointment( @RequestBody AppointmentDto appointmentCreateDto) {
        AppointmentModel appointmentModel = appointmentMapper.fromDto(appointmentCreateDto);
        AppointmentModel savedAppointment = proAppointmentService.add(appointmentModel);
        return appointmentMapper.toDto(savedAppointment);
    }

}
