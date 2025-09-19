package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.request.user.UserRequestDTO;
import com.equipo5.backend.model.enums.Species;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Información para mostrar de las mascotas")
public record PetResponseDTO(
        @Schema(description = "Muestra número identificador de las mascotas")
        Long id,
        @Schema(description = "Muestra el nombre de la mascota")
        String name,
        @Schema(description = "Muestra la especie de la mascota")
        Species species,
        @Schema(description = "Muestra la raza de la mascota")
        String breed,
        @Schema(description = "Muestra la edad de la mascota")
        Integer age,
        @Schema(description = "Muestra información adicional de la mascota")
        String specialNotes,
        @Schema(description = "Muestra información del dueño de la mascota")
        UserRequestDTO owner,
        @Schema(description = "Muestra la lista de las reservas de la mascota")
        List<BookingRequestDTO> bookings) {
}
