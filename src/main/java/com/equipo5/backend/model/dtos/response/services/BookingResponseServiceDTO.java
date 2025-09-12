package com.equipo5.backend.model.dtos.response.services;

import java.time.LocalDateTime;

public record BookingResponseServiceDTO(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status) {
}
