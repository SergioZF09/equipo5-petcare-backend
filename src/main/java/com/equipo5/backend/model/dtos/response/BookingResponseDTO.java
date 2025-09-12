package com.equipo5.backend.model.dtos.response;

import java.time.LocalDateTime;

public record BookingResponseDTO(
        Long id,
        Long id_user,
        Long id_service,
        Long id_pet,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status,
        String specialRequest,
        Double totalPrice) {
}
