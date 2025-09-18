package com.equipo5.backend.model.dtos.response.services;

import com.equipo5.backend.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información para mostrar de los usuarios en general")
public record UserResponseServiceDTO(
        @Schema(description = "Muestra el número identificador del usuario")
        Long id,
        @Schema(description = "Muestra el rol del usuario")
        Role role,
        @Schema(description = "Muestra nombre del usuario")
        String name,
        @Schema(description = "Muestra el correo del usuario")
        String email,
        @Schema(description = "Muestra la contraseña del usuario")
        String password,
        @Schema(description = "Muestra el número de teléfono del usuario")
        String phone,
        @Schema(description = "Muestra la dirección del usuario")
        String address,
        @Schema(description = "Muestra la foto de perfil del usuario")
        String avatarUser) {
}
