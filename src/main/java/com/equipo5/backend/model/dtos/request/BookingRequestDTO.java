package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record BookingRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'startTime'")
        LocalDate startTime,
        @NotBlank(message = "Incomplete attribute: 'endTime'")
        LocalDate endTime,
        /*@NotBlank(message = "Incomplete attribute: 'status'")*/
        Boolean status,
        String specialRequest,
        @NotBlank(message = "Incomplete attribute: 'totalPrice'")
        Double totalPrice) {
}
