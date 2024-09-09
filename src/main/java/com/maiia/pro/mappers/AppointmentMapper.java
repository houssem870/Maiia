package com.maiia.pro.mappers;

import com.maiia.pro.controller.dto.AppointmentDto;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.model.AppointmentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentModel fromDto(AppointmentDto dto);

    Appointment toEntity(AppointmentModel model);

    AppointmentModel fromEntity(Appointment entity);

    AppointmentDto toDto(AppointmentModel model);
}
