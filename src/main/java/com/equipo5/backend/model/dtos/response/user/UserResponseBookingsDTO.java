package com.equipo5.backend.model.dtos.response.user;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Información para mostrar de las reservas de los usuarios")
public record UserResponseBookingsDTO(
        @Schema(description = "Muestra número identificador de la reserva")
        Long id,
        @Schema(description = "Muestra la fecha inicial de la reserva")
        LocalDateTime startTime,
        @Schema(description = "Muestra la fecha de finalización de la reserva")
        LocalDateTime endTime,
        @Schema(description = "Muestra el estado de la reserva", example = "Activo o inactivo")
        Boolean status
) {}
