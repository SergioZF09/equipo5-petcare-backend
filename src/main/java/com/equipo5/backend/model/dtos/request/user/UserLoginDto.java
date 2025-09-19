package com.equipo5.backend.model.dtos.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Información para obtener al iniciar sesión")
public record UserLoginDto (
        @Schema(description = "Correo del usuario")
        @NotBlank(message = "Incomplete attribute: 'email'")
        String email,
        @Schema(description = "Contraseña del usuario")
        @NotBlank(message = "Incomplete attribute: 'password'")
        String password) {}