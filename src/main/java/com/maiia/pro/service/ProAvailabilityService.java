package com.maiia.pro.service;

import com.maiia.pro.entity.Appointment;
import com.maiia.pro.entity.Availability;
import com.maiia.pro.entity.TimeSlot;
import com.maiia.pro.repository.AppointmentRepository;
import com.maiia.pro.repository.AvailabilityRepository;
import com.maiia.pro.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProAvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<Availability> findByPractitionerId(Integer practitionerId) {
        return availabilityRepository.findByPractitionerId(practitionerId);
    }

    public List<Availability> generateAvailabilities(Integer practitionerId) {
        List<TimeSlot> timeSlots = timeSlotRepository.findByPractitionerId(practitionerId);
        List<Appointment> appointments = appointmentRepository.findByPractitionerId(practitionerId);
        List<Availability> availabilities = new ArrayList<>();

        for (TimeSlot timeSlot : timeSlots) {
            LocalDateTime slotStart = timeSlot.getStartDate();
            LocalDateTime slotEnd = timeSlot.getEndDate();

            LocalDateTime currentStart = slotStart;

            while (currentStart.isBefore(slotEnd)) {
                LocalDateTime segmentEnd = currentStart.plusMinutes(15);

                if (segmentEnd.isAfter(slotEnd)) {
                    segmentEnd = slotEnd;
                }

                boolean isAvailable = true;

                for (Appointment appointment : appointments) {
                    if (appointment.getStartDate().isBefore(segmentEnd) && appointment.getEndDate().isAfter(currentStart)) {
                        isAvailable = false;
                        currentStart = appointment.getEndDate();
                        break;
                    }
                }

                if (isAvailable) {
                    availabilities.add(Availability.builder()
                        .practitionerId(practitionerId)
                        .startDate(currentStart)
                        .endDate(segmentEnd)
                        .build());
                    currentStart = segmentEnd;
                }
            }
        }

        return availabilities;
    }

}
