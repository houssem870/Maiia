package com.maiia.pro.service;

import com.maiia.pro.entity.Appointment;
import com.maiia.pro.mappers.AppointmentMapper;
import com.maiia.pro.model.AppointmentModel;
import com.maiia.pro.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    public Appointment find(String appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow();
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findByPractitionerId(Integer practitionerId) {
        return appointmentRepository.findByPractitionerId(practitionerId);
    }


    public AppointmentModel add(AppointmentModel appointmentModel) {
        Appointment appointment = appointmentMapper.toEntity(appointmentModel);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.fromEntity(savedAppointment);
    }
}
