package com.maiia.pro.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientModel {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
