package com.equipo5.backend.model.dtos.request.user;

import com.equipo5.backend.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @NotBlank(message = "Incomplete attribute: 'email'")
        String email,
        @NotBlank(message = "Incomplete attribute: 'password'")
        String password,
        @NotNull(message = "Incomplete attribute: 'rol'")
        Role role,
        String phone,
        String address,
        String avatarUser) {
}
