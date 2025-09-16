package com.equipo5.backend.model.dtos.response.user;

public record UserResponsePetsDTO(
        Long id,
        String name,
        String species,
        String breed
) {}
