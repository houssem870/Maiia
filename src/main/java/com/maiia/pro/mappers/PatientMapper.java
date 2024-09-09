package com.maiia.pro.mappers;


import com.maiia.pro.controller.dto.PatientDto;
import com.maiia.pro.entity.Patient;
import com.maiia.pro.model.PatientModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    // Convert Model to Dto
    PatientModel fromDto(PatientDto patientDto);

    // Convert Model to Entity
    Patient toEntity(PatientModel patientModel);

    // Convert Model to Entity

    PatientModel fromEntity(Patient patient);

    // Convert Model to DTO
    PatientDto toDto(PatientModel patientModel);

}
