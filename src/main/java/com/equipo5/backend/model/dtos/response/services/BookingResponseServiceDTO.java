package com.equipo5.backend.model.dtos.response.services;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Información para mostrar de las reservas para los servicios")
public record BookingResponseServiceDTO(
        @Schema(description = "Muestra el número identificador de la reserva")
        Long id,
        @Schema(description = "Fecha inicial de la reserva")
        LocalDateTime startTime,
        @Schema(description = "Fecha de finalización de la reserva")
        LocalDateTime endTime,
        @Schema(description = "El estado de la reserva 'Activo' o 'Inactivo'")
        Boolean status) {
}
