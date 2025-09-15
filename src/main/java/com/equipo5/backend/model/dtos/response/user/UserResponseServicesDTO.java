package com.equipo5.backend.model.dtos.response.user;

public record UserResponseServicesDTO(
        Long id,
        String type,
        String description,
        Double rate
) {}
