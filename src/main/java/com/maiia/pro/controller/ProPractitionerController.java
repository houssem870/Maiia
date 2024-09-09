package com.maiia.pro.controller;

import com.maiia.pro.controller.dto.PatientDto;
import com.maiia.pro.controller.dto.PractitionerDto;
import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.mappers.PatientMapper;
import com.maiia.pro.mappers.PractitionerMapper;
import com.maiia.pro.model.PatientModel;
import com.maiia.pro.model.PractitionerModel;
import com.maiia.pro.service.ProPractitionerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/practitioners", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProPractitionerController {
    @Autowired
    private ProPractitionerService proPractitionerService;

    @Autowired
    private PractitionerMapper practitionerMapper ;

    @ApiOperation(value = "Get practitioners")
    @GetMapping
    public List<Practitioner> getPractitioners() {
        return proPractitionerService.findAll();
    }

    @ApiOperation(value = "add practitioner")
    @PostMapping
    public PractitionerDto addPractitioner(@RequestBody PractitionerDto practitionerDto) {
        PractitionerModel practitionerModel = practitionerMapper.fromDto(practitionerDto);
        PractitionerModel savedPractitionner = proPractitionerService.add(practitionerModel);
        return practitionerMapper.toDto(savedPractitionner);
    }
}
