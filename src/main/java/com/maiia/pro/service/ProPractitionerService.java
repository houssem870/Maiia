package com.maiia.pro.service;

import com.maiia.pro.entity.Patient;
import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.mappers.PractitionerMapper;
import com.maiia.pro.model.PatientModel;
import com.maiia.pro.model.PractitionerModel;
import com.maiia.pro.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProPractitionerService {
    @Autowired
    private PractitionerRepository practitionerRepository;
    @Autowired
    private PractitionerMapper practitionerMapper ;

    public Practitioner find(String practitionerId) {
        return practitionerRepository.findById(practitionerId).orElseThrow();
    }

    public List<Practitioner> findAll() {
        return practitionerRepository.findAll();
    }

    public PractitionerModel add(final PractitionerModel practitionerModel) {
        Practitioner practitioner = practitionerMapper.toEntity(practitionerModel);
        Practitioner savedPractitioner = practitionerRepository.save(practitioner);
        return practitionerMapper.fromEntity(savedPractitioner);

    }

}
