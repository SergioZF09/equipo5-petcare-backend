package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.UserEntity;

import java.time.LocalDateTime;

public record BookingResponseDTO(
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status,
        Pet pets,
        ServiceEntity services,
        UserEntity owners) {
}
