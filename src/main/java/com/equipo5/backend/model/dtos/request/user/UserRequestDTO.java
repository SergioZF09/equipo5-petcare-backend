package com.equipo5.backend.model.dtos.request.user;

import com.equipo5.backend.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Información para pedir de los usuarios en general")
public record UserRequestDTO(
        @Schema(description = "Nombre del usuario")
        @NotBlank(message = "Incomplete attribute: 'name'")
        String name,
        @Schema(description = "Correo del usuario")
        @NotBlank(message = "Incomplete attribute: 'email'")
        String email,
        @Schema(description = "Contraseña del usuario")
        @NotBlank(message = "Incomplete attribute: 'password'")
        String password,
        @Schema(description = "Rol del usuario a elegir 'OWNER', 'SITTER' o 'ADMINISTRATOR'")
        @NotNull(message = "Incomplete attribute: 'rol'")
        Role role,
        @Schema(description = "Número de teléfono del usuario")
        String phone,
        @Schema(description = "Dirección del usuario")
        String address,
        @Schema(description = "Foto de perfil del usuario")
        String avatarUser) {
}
