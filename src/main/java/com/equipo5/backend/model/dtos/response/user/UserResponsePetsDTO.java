package com.equipo5.backend.model.dtos.response.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información para mostrar de las mascotas de los usuarios")
public record UserResponsePetsDTO(
        @Schema(description = "Muestra número identificador de las mascotas")
        Long id,
        @Schema(description = "Muestra el nombre de la mascota")
        String name,
        @Schema(description = "Muestra la especie de la mascota")
        String species,
        @Schema(description = "Muestra la raza de la mascota")
        String breed
) {}
