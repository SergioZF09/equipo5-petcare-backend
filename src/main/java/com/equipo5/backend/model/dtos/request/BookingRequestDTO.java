package com.equipo5.backend.model.dtos.request;

import java.time.LocalDate;

public record BookingRequestDTO(
        LocalDate startTime,
        LocalDate endTime,
        Boolean status) {
}
