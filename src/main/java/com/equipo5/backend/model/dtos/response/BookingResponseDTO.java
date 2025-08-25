package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.UserEntity;

import java.time.LocalDate;

public record BookingResponseDTO(
        LocalDate startTime,
        LocalDate endTime,
        Boolean status,
        Pet pets,
        ServiceEntity services,
        UserEntity owners) {
}
