package com.maiia.pro.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentModel {
    private Integer patientId;
    private Integer practitionerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
