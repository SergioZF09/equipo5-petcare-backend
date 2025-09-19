package com.equipo5.backend.model.dtos.response.user;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserResponseServicesDTO(
        @Schema(description = "Muestra el número identificador del servicio")
        Long id,
        @Schema(description = "Muestra el tipo del servicio")
        String type,
        @Schema(description = "Muestra la descripción del servicio")
        String description,
        @Schema(description = "Muestra el precio del servicio")
        Double rate
) {}
