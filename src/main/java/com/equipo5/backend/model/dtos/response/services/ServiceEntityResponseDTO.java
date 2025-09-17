package com.equipo5.backend.model.dtos.response.services;

import java.util.List;

public record ServiceEntityResponseDTO(
        Long id,
        String type,
        String description,
        Double rate,
        UserResponseServiceDTO owners,
        List<BookingResponseServiceDTO> bookings) {
}