package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.response.services.PetResponseServiceDTO;
import com.equipo5.backend.model.dtos.response.services.UserResponseServiceDTO;

import java.time.LocalDateTime;

public record BookingResponseDTO(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status,
        String specialRequest,
        Double totalPrice,
        UserResponseServiceDTO user,
        ServiceEntityResponseDTO service,
        PetResponseServiceDTO pet
) {
}
