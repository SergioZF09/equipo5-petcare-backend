package com.equipo5.backend.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record EditBookingStatusRequestDTO(
        @Schema(description = "Estado de la reserva", example = "Activo o inactivo")
        Boolean status
) {
}
