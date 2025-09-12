package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BookingRequestDTO(
        @NotNull(message = "Incomplete id: 'id_user'")
        Long id_user,
        @NotNull(message = "Incomplete id: 'id_service'")
        Long id_service,
        @NotNull(message = "Incomplete id: 'id_pet'")
        Long id_pet,
        @NotNull(message = "Incomplete attribute: 'startTime'")
        LocalDateTime startTime,
        @NotNull(message = "Incomplete attribute: 'endTime'")
        LocalDateTime endTime,
        /*@NotBlank(message = "Incomplete attribute: 'status'")*/
        Boolean status,
        String specialRequest,
        @NotNull(message = "Incomplete attribute: 'totalPrice'")
        Double totalPrice) {
}
