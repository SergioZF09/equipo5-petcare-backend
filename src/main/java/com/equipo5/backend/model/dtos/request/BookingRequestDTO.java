package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record BookingRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'startTime'")
        LocalDateTime startTime,
        @NotBlank(message = "Incomplete attribute: 'endTime'")
        LocalDateTime endTime,
        @NotBlank(message = "Incomplete attribute: 'status'")
        Boolean status) {
}
