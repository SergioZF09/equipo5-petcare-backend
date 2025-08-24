package com.equipo5.backend.model.dtos.request;

public record UserRequestDTO(
        String name,
        String description,
        Double price) {
}
