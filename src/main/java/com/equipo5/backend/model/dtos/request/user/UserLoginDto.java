package com.equipo5.backend.model.dtos.request.user;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto (
        @NotBlank(message = "Incomplete attribute: 'email'")
        String email,
        @NotBlank(message = "Incomplete attribute: 'password'")
        String password) {}