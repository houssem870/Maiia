package com.maiia.pro.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
