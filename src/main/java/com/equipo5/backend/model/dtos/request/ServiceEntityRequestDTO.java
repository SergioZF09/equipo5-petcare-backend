package com.equipo5.backend.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Información para pedir de los servicios")
public record ServiceEntityRequestDTO(
        @Schema(description = "Número identificador del servicio del cuidador")
        Long idSitter,
        @Schema(description = "Tipo del servicio que se ofrece")
        @NotBlank(message = "Incomplete attribute: 'type'")
        String type,
        @Schema(description = "Información detallada del servicio a ofrecer")
        String description,
        @Schema(description = "El precio del servicio que se ofrece")
        @NotNull(message = "Incomplete attribute: 'rate'")
        Double rate) {
}
