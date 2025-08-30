package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRequestDTO(
        @NotNull(message = "Incomplete attribute: ownerId")
        Long ownerId,
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @NotBlank(message = "Incomplete attribute: 'species'")
        String species,
        @NotBlank(message = "Incomplete attribute: 'breed'")
        String breed,
        Integer age,
        String specialNotes) {
}
