package com.equipo5.backend.model.dtos.response;

import java.time.LocalDateTime;

public record UserResponseBookingsDTO(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean status
) {}
