package com.maiia.pro.service;

import com.maiia.pro.controller.dto.PatientDto;
import com.maiia.pro.entity.Patient;
import com.maiia.pro.mappers.PatientMapper;
import com.maiia.pro.model.PatientModel;
import com.maiia.pro.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProPatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientMapper patientMapper ;

    public Patient find(String patientId) {
        return patientRepository.findById(patientId).orElseThrow();
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public PatientModel add(PatientModel patientModel) {
        Patient patient = patientMapper.toEntity(patientModel);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.fromEntity(savedPatient);
    }

}
