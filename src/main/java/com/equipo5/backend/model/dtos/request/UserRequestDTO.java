package com.equipo5.backend.model.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @NotBlank(message = "Incomplete attribute: 'email'")
        String email,
        @NotBlank(message = "Incomplete attribute: 'password'")
        String password,
        String phone,
        String address,
        String avatarUser) {
}
