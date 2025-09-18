package com.equipo5.backend.model.dtos.response.services;

import com.equipo5.backend.model.enums.Species;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información para mostrar de las mascotas de los servicios")
public record PetResponseServiceDTO(
        @Schema(description = "Muestra número identificador de las mascotas")
        Long id,
        @Schema(description = "Muestra el nombre de la mascota")
        String name,
        @Schema(description = "Muestra la especie de la mascota")
        Species species,
        @Schema(description = "Muestra la raza de la mascota")
        String breed
) {
}
