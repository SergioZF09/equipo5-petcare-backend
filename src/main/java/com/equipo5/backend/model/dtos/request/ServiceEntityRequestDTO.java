package com.equipo5.backend.model.dtos.request;

public record ServiceEntityRequestDTO(
        String name,
        String description,
        Double price) {
}
