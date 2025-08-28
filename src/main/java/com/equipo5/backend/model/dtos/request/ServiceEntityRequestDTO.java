package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceEntityRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'name'")
        String type,
        //@NotBlank(message = "Incomplete attribute: 'description'")
        String description,
        @NotNull(message = "Incomplete attribute: 'price'")
        Double rate) {
}
