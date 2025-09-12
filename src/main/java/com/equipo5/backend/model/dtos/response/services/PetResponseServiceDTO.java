package com.equipo5.backend.model.dtos.response.services;

import com.equipo5.backend.model.enums.Species;

public record PetResponseServiceDTO(
        Long id,
        String name,
        Species species,
        String breed
) {
}
