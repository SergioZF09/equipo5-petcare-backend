package com.equipo5.backend.model.dtos.request;

import com.equipo5.backend.model.enums.Species;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Información para pedir y editar de las mascotas")
public record EditPetRequestDTO(
        @Schema(description = "Nombre de la mascota")
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @Schema(description = "Especie de la mascota", example = "Perro o gato")
        @NotNull(message = "Incomplete attribute: 'species'")
        Species species,
        @Schema(description = "Raza de la mascota", example = "Pastor Alemán")
        @NotBlank(message = "Incomplete attribute: 'breed'")
        String breed,
        @Schema(description = "Edad de la mascota")
        Integer age,
        @Schema(description = "Información adicional de la mascota")
        String specialNotes
) {
}
