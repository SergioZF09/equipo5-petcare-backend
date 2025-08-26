package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record PetRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @NotBlank(message = "Incomplete attribute: 'species'")
        String species,
        @NotBlank(message = "Incomplete attribute: 'breed'")
        String breed) {
}
