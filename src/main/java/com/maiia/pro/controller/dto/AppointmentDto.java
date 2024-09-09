package com.maiia.pro.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    private Integer patientId;
    private Integer practitionerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
