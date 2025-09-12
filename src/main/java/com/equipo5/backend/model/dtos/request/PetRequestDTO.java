package com.equipo5.backend.model.dtos.request;

import com.equipo5.backend.model.enums.Species;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRequestDTO(
        @NotNull(message = "Incomplete attribute: ownerId")
        Long ownerId,
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @NotNull(message = "Incomplete attribute: 'species'")
        Species species,
        @NotBlank(message = "Incomplete attribute: 'breed'")
        String breed,
        Integer age,
        String specialNotes) {
}
