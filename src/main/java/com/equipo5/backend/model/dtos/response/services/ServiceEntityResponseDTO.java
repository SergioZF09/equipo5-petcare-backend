package com.equipo5.backend.model.dtos.response.services;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Información de la respuesta sobre el servicio")
public record ServiceEntityResponseDTO(
        @Schema(description = "Muestra el número identificador del servicio del cuidador")
        Long id,
        @Schema(description = "Muestra el tipo del servicio que se ofrece")
        String type,
        @Schema(description = "Muestra la información detallada del servicio a ofrecer")
        String description,
        @Schema(description = "Muestra el precio del servicio que se ofrece")
        Double rate,
        @Schema(description = "Muestra información del dueño")
        UserResponseServiceDTO owners,
        @Schema(description = "Muestra información de las reservas asociadas al servicio")
        List<BookingResponseServiceDTO> bookings) {
}