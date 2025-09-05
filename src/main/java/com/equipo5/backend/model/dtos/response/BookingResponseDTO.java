package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;

import java.time.LocalDateTime;

public record BookingResponseDTO(
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status,
        PetRequestDTO pets,
        ServiceEntityRequestDTO services,
        UserResponseDTO owners) {
}
