package com.maiia.pro.mappers;

import com.maiia.pro.controller.dto.PractitionerDto;
import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.model.PractitionerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PractitionerMapper {

    PractitionerModel fromDto(PractitionerDto practitionerDto);

    Practitioner toEntity(PractitionerModel practitionerModel);

    PractitionerModel fromEntity(Practitioner practitioner);

    PractitionerDto toDto(PractitionerModel practitionerModel);
}
