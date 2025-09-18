package com.equipo5.backend.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "Información para pedir de las reservas")
public record BookingRequestDTO(
        @Schema(description = "Número identificador del usuario")
        @NotNull(message = "Incomplete id: 'id_user'")
        Long id_user,
        @Schema(description = "Número identificador del servicio")
        @NotNull(message = "Incomplete id: 'id_service'")
        Long id_service,
        @Schema(description = "Número identificador de la mascota")
        @NotNull(message = "Incomplete id: 'id_pet'")
        Long id_pet,
        @Schema(description = "Fecha inicial de la reserva")
        @NotNull(message = "Incomplete attribute: 'startTime'")
        LocalDateTime startTime,
        @Schema(description = "Fecha de finalización de la reserva")
        @NotNull(message = "Incomplete attribute: 'endTime'")
        LocalDateTime endTime,
        /*@NotBlank(message = "Incomplete attribute: 'status'")*/
        @Schema(description = "Estado de la reserva", example = "Activo o inactivo")
        Boolean status,
        @Schema(description = "Información adicional de la reserva")
        String specialRequest,
        @Schema(description = "Precio total de la reserva")
        @NotNull(message = "Incomplete attribute: 'totalPrice'")
        Double totalPrice) {
}
