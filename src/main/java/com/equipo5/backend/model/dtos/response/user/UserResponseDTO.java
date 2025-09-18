package com.equipo5.backend.model.dtos.response.user;

import com.equipo5.backend.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Información para mostrar de los usuarios en general")
public record UserResponseDTO(
        @Schema(description = "Muestra el número identificador del usuario")
        Long id,
        @Schema(description = "Muestra el rol del usuario a elegir 'OWNER', 'SITTER' o 'ADMINISTRATOR'")
        Role role,
        @Schema(description = "Muestra el nombre del usuario")
        String name,
        @Schema(description = "Muestra el correo del usuario")
        String email,
        //String password,
        @Schema(description = "Muestra el número de teléfono del usuario")
        String phone,
        @Schema(description = "Muestra la dirección del usuario")
        String address,
        @Schema(description = "Muestra la foto de perfil del usuario")
        String avatarUser,
        @Schema(description = "Muestra la lista de las mascotas del usuario")
        List<UserResponsePetsDTO> pets,
        @Schema(description = "Muestra la lista de los servicios del usuario")
        List<UserResponseServicesDTO> services,
        @Schema(description = "Muestra la lista de las reservas del usuario")
        List<UserResponseBookingsDTO> bookings
) {}