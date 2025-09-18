package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.user.UserResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Información para mostrar de los servicios")
public record ServiceEntityResponseDTO(
        @Schema(description = "Muestra el tipo del servicio")
        String type,
        @Schema(description = "Muestra la descripción del servicio")
        String description,
        @Schema(description = "Muestra el precio del servicio")
        Double rate,
        @Schema(description = "Muestra los usuarios del servicio")
        UserResponseDTO owners,
        @Schema(description = "Muestra la lista de las reservas del servicio")
        List<BookingRequestDTO> bookings) {
}
