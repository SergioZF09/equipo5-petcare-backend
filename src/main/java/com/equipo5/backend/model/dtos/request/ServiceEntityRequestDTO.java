package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceEntityRequestDTO(
        Long idSitter,
        @NotBlank(message = "Incomplete attribute: 'name'")
        String type,
        String description,
        @NotNull(message = "Incomplete attribute: 'rate'")
        Double rate) {
}
